package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2501번 - 약수 구하기 (브론즈 3)
 * 
 * 어떤 자연수 p와 q가 있을 때, 
 * 만일 p를 q로 나누었을 때 나머지가 0이면 q는 p의 약수이다.
 * 
 * 6의 약수는 1, 2, 3, 6, 총 네 개이다.
 * 
 * 두 개의 자연수 N과 K가 주어졌을 때, N의 약수들 중 K번째로 작은 수를 출력하는 프로그램을 작성하시오.
 */

public class BOJ_2501_약수_구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0;	// 약수 카운팅 변수
		int answer = 0;	// N의 약수들 중 K번째로 작은 수
		
		for (int i = 1; i <= N; i++) {
			// i가 N의 약수이면 개수를 센다.
			if (N % i == 0)	cnt++;
			
			// 개수가 K이면 i를 출력한다.
			if (cnt == K) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
