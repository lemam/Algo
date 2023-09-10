/*
 * 백준 14425번 - 문자열 집합 (실버 3)
 * 
 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
 * 입력으로 주어지는 M개의 문자열 중에서 
 * 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_14425_문자열_집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	//  문자열의 개수
		int M = Integer.parseInt(st.nextToken());	//  입력 개수
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int answer = 0;	// 집합 S에 포함되어 있는 문자열의 개수
		
		// 집합 S의 문자열 입력
		for (int i = 0; i < N; i++) {
			map.put(br.readLine(), 0);
		}
		
		// M개의 문자열 검사
		for (int i = 0; i < M; i++) {
			// map에 문자열이 포함되어 있으면 개수를 센다.
			if (map.containsKey(br.readLine()))
				answer++;
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
