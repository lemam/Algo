package SWEA;
/*
 * SWEA 2007번 - 패턴 마디의 길이 (D2)
 * 
 * 패턴에서 반복되는 부분을 마디라고 부른다. 
 * 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.
 * 
 * 각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.
 * 
 * <추가>
 * 1. 반복되는 마디 중 크기가 가장 작은 마디의 길이를 출력해야 함 (ex: aaaaa 의 경우, 1~5 전부 마디가 될 수 있지만 1 출력)
 * 2. 마디가 반복되다가 문자열의 끝에서 잘리는 경우 (ex: aabbb aabbb aabb) 잘린 문자열은 마디의 앞부분과 일치하기만 하면 됨, 이 경우 5 출력
 * 3. 입력값으로 주어지는 문자열은 컨트롤 문자 등 출력 불가능한 문자들을 제외한 문자
 */

import java.util.Scanner;

public class SWEA_2007_패턴_마디의_길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();	// 입력받은 문자열
			int len = str.length();

			for (int i = 1; i <= len; i++) {
				String word = str.substring(0, i);	// 0부터 i-1까지의 문자열 (마디)
				String next = str.substring(i, i + i);	// 마디 다음의 같은 길이의 문자열

				// 마디와 다음 문자열이 같다면 
				// 최소 길이의 마디로 이루어진 패턴이므로 마디의 길이를 출력한다. 
				if (word.equals(next)) {
					System.out.printf("#%d %d\n", tc, word.length());
					break;
				}
			}
		}

		sc.close();
	}

}
