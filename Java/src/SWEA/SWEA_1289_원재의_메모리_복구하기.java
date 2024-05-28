package SWEA;

import java.util.Scanner;

/*
 * SWEA 1289번 - 원재의 메모리 복구하기 (D3)
 * 
 * 원재가 컴퓨터를 만지다가 실수를 저지르고 말았다. 메모리가 초기화된 것이다.
 * 다행히 원래 메모리가 무슨 값이었는지 알고 있었던 원재는 바로 원래 값으로 되돌리려고 했으나 메모리 값을 바꿀 때 또 문제가 생겼다.
 * 
 * 메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것이다.
 * 예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.
 * 
 * 원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산해보자.
 * 초기값(모든bit가 0)에서 원래 값으로 복구하기 위한 최소 수정 횟수를 출력한다.
 */

public class SWEA_1289_원재의_메모리_복구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			String memory = sc.next(); // 메모리의 원래 값
			int toggleNum = 1; // 바꿔야 할 수
			int answer = 0; // 최소 수정 횟수

			int len = memory.length();

			// 메모리를 1bit씩 읽으면서 바꿔야할 수를 만나면 횟수를 센다.
			for (int i = 0; i < len; i++) {
				int num = Character.getNumericValue(memory.charAt(i));

				if (num == toggleNum) {
					// 다음 바꿔야 할 수를 0이면 1로, 1이면 0으로 바꾼다.
					toggleNum = (toggleNum + 1) % 2;
					answer++;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
