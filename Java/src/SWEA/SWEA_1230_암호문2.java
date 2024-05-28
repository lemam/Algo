package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * SWEA 1230번 - 암호문2 (D3)
 * 
 * 0 ~ 999999 사이의 수로 표현되는 암호문이 있고, 이 암호문을 N개 모아 놓은 암호문 뭉치가 있다.
 * 암호문은 특수 제작된 처리기로만 수정이 가능하다.
 * 
 * 처리기는 다음과 같이 3개의 명령어로 제어한다.
 * 1. I(삽입) x, y, s : 앞에서부터 x번째 암호문 바로 다음에 y개의 암호문을 삽입한다. s는 덧붙일 암호문들이다.
 * [ ex) I 3 2 123152 487651 ]
 * 
 * 2. D(삭제) x, y : 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.
 * [ ex) D 4 4 ]
 * 
 * 3. A(추가) y, s : 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다. s는 덧붙일 암호문들이다. 
 * [ ex) A 2 421257 796813 ]
 * 
 * 위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 
 * 암호문 뭉치를 수정하고, 수정된 결과의 처음 10개 암호문을 출력하는 프로그램을 작성하여라.
 */

public class SWEA_1230_암호문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = 1; // 테스트 케이스

		while (sc.hasNext()) {
			LinkedList<String> list = new LinkedList<>();
			int N = sc.nextInt(); // 원본 암호문 뭉치 속 암호문의 개수

			// 원본 암호문 뭉치 입력
			for (int i = 0; i < N; i++) {
				list.add(sc.next());
			}

			int M = sc.nextInt(); // 명령어의 개수

			for (int i = 0; i < M; i++) {
				int x = 0, y = 0;

				String code = sc.next();

				// 명령어 입력
				if (code.equals("I")) {
					x = sc.nextInt();
					y = sc.nextInt();

					// 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다.
					for (int j = 0, idx = x; j < y; j++, idx++) {
						list.add(idx, sc.next());
					}

				} else if (code.equals("D")) {
					x = sc.nextInt();
					y = sc.nextInt();

					// 앞에서부터 x번째 암호문 바로 다음부터 y개의 암호문을 삭제한다.
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}

				} else if (code.equals("A")) {
					y = sc.nextInt();

					// 암호문 뭉치 맨 뒤에 y개의 암호문을 덧붙인다.
					for (int j = 0; j < y; j++) {
						list.addLast(sc.next());
					}

				}

			}

			System.out.print("#" + tc + " ");

			for (int i = 0; i < 10; i++)
				System.out.print(list.get(i) + " ");

			System.out.println();

			tc++;
		}

		sc.close();
	}
}
