package Baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_1181_단어_정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());	// 단어의 개수
		
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for (String str : set) {
			bw.append(str + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
