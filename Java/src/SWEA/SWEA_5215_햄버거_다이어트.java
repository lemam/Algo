package SWEA;

import java.util.Scanner;

/*
 * SWEA 5215번 - 햄버거 다이어트 (D3)
 * 
 * 햄버거를 포기할 수 없었던 민기는 햄버거의 맛은 최대한 유지하면서 정해진 칼로리를 넘지 않는 햄버거를 주문하여 먹으려고 한다.
 * 
 * 민기가 주로 이용하는 햄버거 가게에서는 고객이 원하는 조합으로 햄버거를 만들어서 준다.
 * 하지만 재료는 미리 만들어서 준비해놓기 때문에 조합에 들어가는 재료를 잘라서 조합해주지는 않고, 
 * 재료를 선택하면 준비해놓은 재료를 그대로 사용하여 조합해준다. 
 * 
 * 민기는 이 가게에서 자신이 먹었던 햄버거의 재료에 대한 맛을 자신의 오랜 경험을 통해 점수를 매겨놓았다.
 * 
 * 민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
 * 민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 
 * 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.
 * 
 * (단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고, 
 * 같은 재료를 여러 번 사용할 수 없으며, 햄버거의 조합의 제한은 칼로리를 제외하고는 없다.)
 */

public class SWEA_5215_햄버거_다이어트 {
	public static int N; // 재료의 수
	public static int L; // 제한 칼로리
	public static int[][] data; // 재료 배열 [재료 인덱스][점수, 칼로리]
	public static boolean[] sel; // 선택한 조합 저장 배열
	public static int answer; // 조합한 햄버거 조합 점수의 최댓값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 재료의 수
			L = sc.nextInt(); // 제한 칼로리
			data = new int[N][2]; // 재료 배열 [재료 인덱스][점수, 칼로리]

			// 배열 입력
			for (int i = 0; i < N; i++) {
				data[i][0] = sc.nextInt(); // 점수
				data[i][1] = sc.nextInt(); // 칼로리
			}

			sel = new boolean[N];
			answer = 0;

			powerset(0);

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// 모든 조합 구하기
	// depth : 현재 깊이
	public static void powerset(int depth) {
		if (depth == N) {
			// 햄버거 조합의 점수 중 최댓값
			answer = Math.max(answer, getCombScore());
			return;
		}

		sel[depth] = false;
		powerset(depth + 1);
		sel[depth] = true;
		powerset(depth + 1);
	}

	// 햄버거 조합의 점수를 반환한다.
	public static int getCombScore() {
		int sum = 0; // 조합 점수
		int cal = 0; // 조합 칼로리

		// 조합된 재료의 점수의 합과 칼로리의 합을 계산한다.
		for (int i = 0; i < sel.length; i++) {
			if (sel[i]) {
				sum += data[i][0];
				cal += data[i][1];
			}
		}
		
		// 조합의 칼로리가 제한 칼로리 초과이면 0을 반환
		if (cal > L) return 0;

		// 아니면 점수를 반환
		return sum;
	}
}
