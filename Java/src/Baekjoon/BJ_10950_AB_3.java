package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10950_AB_3 {
	public static void main(String[] args) throws IOException {
		/*
		 * 두 정수 A와 B를 입력받은 다음, A + B 출력
		 * 테스트 케이스 개수 : T
		 * (0 < A, B < 10)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(A + B);
		}
	}
}
