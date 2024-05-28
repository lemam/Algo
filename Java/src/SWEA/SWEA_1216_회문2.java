package SWEA;

import java.util.Scanner;

/*
 * SWEA 1216번 - 회문2 (D3)
 * "기러기" 또는 "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
 * 주어진 100x100 평면 글자판에서 가로, 세로를 모두 보아 가장 긴 회문의 길이를 구하는 문제이다.
 * 
 * ABA도 회문이며, ABBA도 회문이다. A또한 길이 1짜리 회문이다.
 * 가로, 세로 각각에 대해서 직선으로만 판단한다.
 */
public class SWEA_1216_회문2 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스
		int N = 100; // 글자판 한 변의 길이

		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt(); // 테스트 케이스 번호
			String[][] map = new String[N][N]; // 글자판
			int answer = 0; // 가장 긴 회문의 길이

			// 글자판 입력
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().split("");
			}

			// 가로 탐색
			for (int i = 0; i < N; i++) {
				String text = ""; // i번째 행의 한 줄 문자열

				// i번째 행의 한 줄 문자열 가져오기
				for (int j = 0; j < N; j++) {
					text += map[i][j];
				}

				for (int k = 0; k < N; k++) {
					// 뒤에서부터 길이를 1씩 줄여가면서 회문인지 판단한다.
					for (int l = N; l > 0; l--) {
						String str = text.substring(k, l);

						// 만약 회문이라면 반복문을 멈추고 최댓값인지 판단한 후 저장한다.
						if (isPalindrome(str)) {
							answer = Math.max(answer, str.length());
							break;
						}
					} // k ~ l까지의 문자열이 회문인지 판단
				} // 탐색 시작 열 인덱스
			} // 탐색 시작 행

			// 세로 탐색
			for (int j = 0; j < N; j++) {
				String text = ""; // i번째 열의 한 줄 문자열

				// i번째 열의 한 줄 문자열 가져오기
				for (int i = 0; i < N; i++) {
					text += map[i][j];
				}

				for (int k = 0; k < N; k++) {
					// 길이를 1씩 줄여가면서 회문인지 판단한다.
					for (int l = N; l > 0; l--) {
						String str = text.substring(k, l);

						// 만약 회문이라면 반복문을 멈추고 최댓값인지 판단한 후 저장한다.
						if (isPalindrome(str)) {
							answer = Math.max(answer, str.length());
							break;
						}
					} // k ~ l까지의 문자열이 회문인지 판단
				} // 탐색 시작 행 인덱스
			} // 탐색 시작 열

			System.out.printf("#%d %d\n", t, answer);
		}

		sc.close();
	}

	// str이 회문인지를 판단하여 boolean 값으로 반환한다.
	public static boolean isPalindrome(String str) {
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	public static String caseStr = "CBCABBAC\nBBABCABA\nABCBCCCA\nBACCAABB\nBCBCACBC\nCABACACB\nCAAACCAB\nCBABACAC";
}