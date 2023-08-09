package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2745번 - 진법 변환 (브론즈 2)
 * 
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * 
 * 10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다. 이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */

public class BOJ_2745_진법_변환 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String N = st.nextToken(); // B진법 수
		int B = Integer.parseInt(st.nextToken()); // B진법
		int answer = 0; // 10진법 결과값

		// 한 글자씩 읽으면서 10진수로 변환
		for (int i = 0; i < N.length(); i++) {
			char ch = N.charAt(i);
			int num = 0;

			if (ch >= '0' && ch <= '9') {
				num = (int) ch - (int) '0';
			} else if (ch >= 'A' && ch <= 'Z') {
				num = (int) ch - (int) 'A' + 10;
			}

			answer += num * (int) Math.pow(B, N.length() - 1 - i);
		}

		System.out.println(answer);

		br.close();
	}
}
