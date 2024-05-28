package SWEA;

import java.util.Scanner;

/*
 * SWEA 1989번 - 초심자의 회문 검사 (D2)
 * 
 * "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
 * 단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.
 */

public class SWEA_1989_초심자의_회문_검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String word = sc.next();
			int len = word.length();
			int answer = 1;

			// 단어를 반으로 나눈 값들
			String w1 = word.substring(0, len / 2);
			String w2 = word.substring(len / 2);
			
			// 앞에서부터 가져온 w1의 문자들과 뒤에서부터 w2의 문자들을 w1의 단어의 개수만큼 비교한다.
			for (int i = 0; i < w1.length(); i++) {
				// 회문이 아니면 0을 출력
				if (w1.charAt(i) != w2.charAt(w2.length() - 1 - i)) {
					answer = 0;
					break;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
