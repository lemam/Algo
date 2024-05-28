package SWEA;/*
 * SWEA 1940번 - 가랏! RC카! (D2)
 * 
 * RC (Radio Control) 카의 이동거리를 계산하려고 한다.
 * 
 * 입력으로 매 초마다 아래와 같은 command 가 정수로 주어진다.
 * 0 : 현재 속도 유지.
 * 1 : 가속
 * 2 : 감속
 * 
 * 위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.
 * 가속도의 단위는, m/s^2 이며, 모두 양의 정수로 주어진다.
 * 
 * 입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산하는 프로그램을 작성하라.
 * RC 카의 초기 속도는 0 m/s 이다.
 * 
 * 가속도의 값은 1 m/s2 혹은 2 m/s2 이다.
 * 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
 */

import java.util.Scanner;

public class SWEA_1940_가랏_RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	// 테스트 케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();	// command 수
			int curSpeed = 0;	// 현재 속도
			int distance = 0;	// 거리
			
			for (int i = 0; i < N; i++) {
				int com = sc.nextInt();	// 명령어
				
				// 가속
				if (com == 1) {
					int acc = sc.nextInt();	// 가속도
					curSpeed += acc;
				}
				// 감속
				else if (com == 2) {
					int acc = sc.nextInt();	// 가속도
					curSpeed -= acc;
					
					// 현재 속도는 0을 내려가지 않는다.
					if (curSpeed < 0) curSpeed = 0;
				}
				
				distance += curSpeed;
			}
			
			System.out.printf("#%d %d\n", tc, distance);
		}
		
		sc.close();
	}
}
