/*
 * SWEA 1240번 - 단순 2진 암호코드 (D3)
 * 
 * 어떤 국가에서는 자국 내 방송국에서 스파이가 활동하는 사실을 알아냈다. 
 * 스파이는 영상물에 암호 코드를 삽입하여 송출하고 있었다. 
 * 스파이의 암호 코드에 다음과 같은 규칙이 있음을 발견했다.
 * 
 * 1. 암호코드는 8개의 숫자로 이루어져 있다.
 * 2. 올바른 암호코드는 (홀수 자리의 합 x 3) + (짝수 자리의 합)이 10의 배수가 되어야 한다.
 * 
 * 이 암호코드들을 빠르고 정확하게 인식할 수 있는 스캐너를 개발하려고 한다.
 * 스캐너는 암호코드 1개가 포함된 직사각형 배열을 읽는다.
 * 직사각형 배열은 1, 0으로만 이루어져 있고, 암호코드 이외의 부분은 전부 0으로 주어진다.
 * 암호코드에서 숫자 하나는 7개의 비트로 암호화되어 주어진다. 따라서 암호코드의 가로 길이는 56이다.
 * 
 * 비정상적인 암호코드(가로 길이가 56이 아닌 경우, 아래 규칙대로 해독할 수 없는 경우)는 주어지지 않는다.
 * 암호코드 정보가 포함된 2차원 배열을 입력으로 받아 올바른 암호코드인지 판별하는 프로그램을 작성하라.
 * 
 * 주어진 암호코드가 올바른 암호코드일 경우, 암호코드에 포함된 숫자의 합을 출력하라. 
 * 만약 잘못된 암호코드일 경우 대신 0을 출력하라.
 */

import java.util.Scanner;

public class SWEA_1240_단순_2진_암호코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		// 암호코드 해독 규칙
		String[] keys = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 직사각형 세로 크기
			int M = sc.nextInt(); // 직사각형 가로 크기
			char[][] map = new char[N][M]; // 직사각형 배열

			// 1. 직사각형 배열 입력
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
			}

			// 2. 암호코드 추출
			int bitCnt = 7; // 한 숫자를 이루는 비트의 개수
			int codeCnt = 8; // 암호코드를 이루는 숫자의 개수
			char[] code = new char[bitCnt * codeCnt];

			out: for (int i = 0; i < N; i++) {
				// 뒤에서 부터 읽기
				for (int j = M - 1; j >= 0; j--) {
					// 1을 만나면
					if (map[i][j] == '1') {
						// 암호코드를 추출한다.
						for (int k = 0; k < code.length; k++) {
							code[code.length - 1 - k] = map[i][j - k];
						}

						break out;
					}
				}
			}

			// 3. 암호코드 해독
			int[] numbers = new int[8]; // 해독된 숫자 배열

			for (int i = 0; i < code.length; i += bitCnt) {
				char[] bits = new char[bitCnt]; // 한 숫자의 비트 배열

				// 7비트를 배열에 저장한다.
				for (int j = 0; j < bitCnt; j++) {
					bits[j] = code[i + j];
				}

				String num = new String(bits); // 숫자 한 개의 암호코드 문자열

				// 암호코드를 해독하여 배열에 저장한다.
				for (int j = 0; j < keys.length; j++) {
					if (keys[j].equals(num)) {
						numbers[i / 7] = j;
						break;
					}
				}
			}

			// 4. 올바른 암호코드인지 확인
			int sum = 0; // 올바른 암호코드 확인용
			int answer = 0; // 암호코드의 총합

			// 홀수 자리의 합 * 3;
			for (int i = 0; i < numbers.length; i += 2) {
				sum += numbers[i];
				answer += numbers[i];
			}

			sum *= 3;

			// 짝수 자리의 합
			for (int i = 1; i < numbers.length; i += 2) {
				sum += numbers[i];
				answer += numbers[i];
			}

			System.out.print("#" + tc + " ");

			// 10이 배수이면 올바른 암호코드
			if (sum % 10 == 0)
				System.out.println(answer);
			else
				System.out.println(0);
		}

		sc.close();
	}
}
