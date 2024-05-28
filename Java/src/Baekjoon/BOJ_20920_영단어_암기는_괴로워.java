package Baekjoon;/*
 * 백준 20920번 - 영단어 암기는 괴로워 (실버 3)
 * 
 * 화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 
 * 그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 
 * 화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.
 * 
 * 1. 자주 나오는 단어일수록 앞에 배치한다.
 * 2. 해당 단어의 길이가 길수록 앞에 배치한다.
 * 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 * 
 * M보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 
 * 길이가 M이상인 단어들만 외운다고 한다.
 * 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920_영단어_암기는_괴로워 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 단어의 개수
		int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준

		Map<String, Integer> map = new HashMap<String, Integer>(); // <단어, 개수>

		// N개의 단어 입력
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			// 길이가 M 이하인 단어는 외우지 않는다.
			if (input.length() < M)	continue;

			// 단어의 빈도수 저장
			map.put(input, map.getOrDefault(input, 0) + 1);
		}

		List<String> words = new ArrayList<>(map.keySet());

		// words 리스트 정렬
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 1. 자주 등장하는 순서대로 정렬
				if (map.get(o2) - map.get(o1) != 0)
					return map.get(o2) - map.get(o1);

				// 2. 등장 횟수가 같으면 길이가 긴 순서대로 정렬
				if (o1.length() != o2.length())
					return o2.length() - o1.length();

				// 3. 등장 횟수와 길이가 같으면 사전 순으로 정렬
				return o1.compareTo(o2);
			}
		});

		// 정렬된 단어들 출력
		StringBuilder sb = new StringBuilder();

		for (String word : words)
			sb.append(word).append("\n");

		System.out.println(sb);

		br.close();
	}
}
