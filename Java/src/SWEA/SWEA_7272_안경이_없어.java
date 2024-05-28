package SWEA;/*
 * SWEA 7272번 - 안경이 없어! (D3)
 * 
 * 어느 날 경근이는 알파벳 대문자로 이루어진 두 문자열을 비교해야 했는데, 이 날은 공교롭게도 안경이 없었다.
 * 
 * 경근이는 매우 눈이 나빠서 안경을 벗으면 
 * 문자열을 문자 단위로 구별할 수는 있지만, 두 문자가 정확히 같은 지는 알지 못한다.
 * 
 * 특히 알파벳 대문자 같은 경우 
 * 문자에 나 있는 구멍의 개수가 같으면 같은 문자이고, 다르면 다른 문자라고 생각한다.
 * 
 * 예를 들어 구멍이 하나도 없는 CEFGHIJKLMNSTUVWXYZ들을 같은 문자로 생각하고, 
 * 구멍이 한 개 나 있는 ADOPQR들을 같은 문자로 생각하며, 
 * 구멍이 두 개 나 있는 유일한 문자 B는 유일하게 정확히 알 수 있다.
 * 
 * 알파벳 대문자로 이루어진 두 문자열이 주어졌을 때, 경근이는 두 문자열이 같다고 판별하는지 다르다고 판별할 것인가?
 * 
 * 경근이가 주어진 두 문자열을 같은 것으로 생각하면 “SAME”을, 다른 것으로 생각하면 “DIFF”를 출력한다.
 */

import java.util.Scanner;

public class SWEA_7272_안경이_없어 {
	// A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z
	public static int[] alphabet = { 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			// 비교할 두 문자열
			String str1 = sc.next();
			String str2 = sc.next();

			// 두 문자열 비교
			String answer = solution(str1, str2);

			System.out.printf("#%d %s\n", tc, answer);
		}

		sc.close();
	}

	// 경근이가 두 문자열이 같은지 판별한 값을 반환한다.
	private static String solution(String str1, String str2) {
		// 두 문자열의 길이가 다르면 서로 다르다고 판단한다.
		if (str1.length() != str2.length())
			return "DIFF";

		int len = str1.length();

		// 한 글자씩 비교
		for (int i = 0; i < len; i++) {
			int num1 = str1.charAt(i) - 'A';
			int num2 = str2.charAt(i) - 'A';
			
			if (alphabet[num1] != alphabet[num2])
				return "DIFF";
		}
		
		return "SAME";
	}
}
