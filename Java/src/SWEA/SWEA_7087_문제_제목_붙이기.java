package SWEA;/*
 * SWEA 7087번 - 문제 제목 붙이기 (D3)
 * 
 * 은기와 자영이는 대회에 사용할 문제를 준비하는 과정에서 문제 제목을 정하게 되었다.
 * 은기는 대회의 문제들에 사용할 수 있는 제목을 N개 만들었다.
 * 
 * 자영이는 제목의 가장 앞 글자에
 * 알파벳 대문자 A부터 시작하여, A, B, C, … , Z가 순서대로 한 번씩 등장하면 좋겠다고 하였다.
 * 
 * 만약 도중에 특정 알파벳이 문제 제목의 맨 앞 글자로 등장하지 않으면 그 이후의 알파벳은 사용하지 않는다.
 * 예를 들어, 문제 제목으로 Air, Dad, Ear, Blue, Ace가 있다면, 
 * A와 B는 등장하였지만, C는 등장하지 않았기 때문에 최대 2개의 문제 제목을 사용할 수 있는 것이다.
 * 
 * 은기가 만든 문제들의 제목이 주어질 때, 자영이가 정한 규칙에 따라서 사용할 수 있는 최대 문제 제목의 개수를 계산하는 프로그램을 작성하라.
 */

import java.util.Scanner;

public class SWEA_7087_문제_제목_붙이기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 사용할 수 있는 제목의 개수

			String[] titles = new String[N]; // 사용할 수 있는 제목 배열
			int answer = 0; // 사용할 수 있는 최대 문제 제목의 개수

			// 배열 입력
			for (int i = 0; i < N; i++) {
				titles[i] = sc.next();
			}

			for (int i = 0; i < N; i++) {
				char alphabet = (char) ('A' + i);
				boolean hasAlphabet = false; // 알파벳이 등장한 여부를 체크

				// 제목 배열 탐색
				for (int j = 0; j < N; j++) {
					// 제목의 첫 글자가 해당 알파벳과 같으면 해당 제목을 빈칸으로 바꾼다.
					if (titles[j].charAt(0) == alphabet) {
						titles[j] = " ";
						hasAlphabet = true;
						answer++;
						break;
					}
				}

				// 특정 알파벳이 문제 제목의 맨 앞 글자로 등장하지 않으면 탐색을 중단한다.
				if (!hasAlphabet) break;
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
