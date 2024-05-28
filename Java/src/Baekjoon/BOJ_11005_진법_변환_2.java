package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 11005번 - 진법 변환 2 (브론즈 1)
 * 
 * 10진법 수 N이 주어진다. 
 * 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */

public class BOJ_11005_진법_변환_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int diff = 'A' - 10; // 65 - 10 = 55
		String answer = "";

		while (N != 0) {
			int q = N % B;
			// 나머지가 9보다 크면 알파벳 대문자를, 9보다 작으면 숫자를 저장한다.
			String str = (q > 9) ? (char) (q + diff) + "" : q + "";

			// 문자열의 앞에 추가한다.
			answer = str + answer;
			N /= B;
		}

		System.out.println(answer);

		br.close();
	}
}
