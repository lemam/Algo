package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/*
 * SWEA 2112번 - 보호 필름
 * 
 * 성능이 우수한 보호 필름을 제작하려고 한다.
 * 보호 필름은 [Fig. 1]와 같은 엷은 투명한 막을 D장 쌓아서 제작된다.
 * 막은 [Fig. 1]과 같이 동일한 크기를 가진 바(bar) 모양의 셀들이 가로 방향으로 W개 붙여서 만들어진다.
 * 이렇게 제작된 필름은 두께 D, 가로 크기 W의 보호 필름이라고 한다.
 * 
 * 각 셀들은 특성 A 또는 특성 B를 가지고 있다. 
 * 보호 필름의 성능은 셀들의 특성이 어떻게 배치됨에 따라 결정된다.
 * 
 * [Fig. 1]은 셀 6개를 이어서 만든 막의 단면이다.
 * [Fig. 2]는 셀 8개로 이루어진 엷은 막 6장을 쌓아서 만든 두께 6, 가로크기 8인 보호 필름의 단면이다. 
 * A, B는 각 셀들이 가진 특성 A, 특성 B를 의미한다.
 * 
 * 보호 필름의 성능을 검사하기 위해 합격기준 K라는 값을 사용한다.
 * 충격은 보호 필름 단면의 세로 방향으로 가해지므로, 세로 방향 셀들의 특성이 중요하다. 
 * 단면의 모든 세로방향에 대해서 동일한 특성의 셀들이 K개 이상 연속적으로 있는 경우에만 성능검사를 통과하게 된다.
 * 동일한 특성을 지닌 셀이 3개 이상 연속적으로 있지 않으므로 성능검사를 통과할 수 없다.
 * 
 * 성능검사에 통과하기 위해서 약품을 사용하여야 한다. 
 * 약품은 막 별로 투입할 수 있으며 이 경우 투입하는 막의 모든 셀들은 하나의 특성으로 변경된다. 
 * 특정 막에 약품 A를 투입하면 막 내의 모든 셀들이 특성 A로 변경되며, 
 * 약품 B를 넣게 되면 특성이 모두 특성 B로 변경된다.
 * 
 * 두께 D, 가로크기 W인 보호 필름 단면의 정보와 합격기준 K가 주어졌을 때, 
 * 약품 투입 횟수를 최소로 하여 성능검사를 통과할 수 있는 방법을 찾고, 
 * 이때의 약품 투입 횟수를 출력하라. 
 * 약품을 투입하지 않고도 성능검사를 통과하는 경우에는 0을 출력한다.
 * 
 * (특성A는 0, 특성B는 1로 표시된다.)
 */

public class SWEA_2112_보호_필름 {
	public static int D; // 필름 두께
	public static int W; // 가로 크기
	public static int K; // 합격 기준
	public static int[][] film; // 보호 필름 단면의 정보 배열
	public static int answer; // 약품 최소 투입 횟수

	public static int[] A; // 약품 A를 투입한 막 배열
	public static int[] B; // 약품 B를 투입한 막 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();

			film = new int[D][W];

			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}

			A = new int[W];
			Arrays.fill(A, 0);

			B = new int[W];
			Arrays.fill(B, 1);

			answer = Integer.MAX_VALUE;

			// 약품 투입의 모든 경우의 수 확인하기
			solution(0, 0);
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// depth : 현재 깊이
	// cnt : 현재 약물 투입 횟수
	public static void solution(int depth, int cnt) {
		// 현재 투입 횟수가 저장된 약품 최소 투입 횟수보다 크면 중단한다.
		if (cnt > answer) return;

		// 성능 검사 실시
		if (testPerformance()) {
			// 성공하면 약품 최소 투입 횟수로 값을 저장한다.
			answer = cnt;
			return;
		}

		// 모든 막을 확인한 경우
		if (depth == D)	return;

		// 1. 약물을 안 넣는다.
		solution(depth + 1, cnt);

		int[] origin = film[depth]; // depth 막의 원본 배열

		// 2. 약품 A를 투입한다.
		film[depth] = A;
		solution(depth + 1, cnt + 1);

		// 3. 약품 B를 투입한다.
		film[depth] = B;
		solution(depth + 1, cnt + 1);
		
		// 원상 복구한다.
		film[depth] = origin;
	}

	// 모든 세로방향에 대해서 동일한 특성의 셀들이 연속적으로 K개 이상 있으면 통과
	private static boolean testPerformance() {
		for (int j = 0; j < W; j++) {
			int count = 0; // 동일한 특성의 연속 개수
			int prev = 0; // 직전 셀의 특성
			boolean isPassed = false; // 해당 세로 방향의 성능검사 통과 여부

			for (int i = 0; i < D; i++) {
				// 직전 특성과 동일하면 개수를 센다.
				if (film[i][j] == prev)
					count++;
				// 직전 특성과 동일하지 않으면 count를 초기화한다.
				else
					count = 1;

				// 동일한 특성의 셀들의 연속 개수가 K개 이상이면 해당 세로 방향의 성능검사 통과
				if (count >= K) {
					isPassed = true;
					break;
				}

				// prev를 갱신한다.
				prev = film[i][j];
			}

			// j열에서 성능검사를 통과하지 못했다면 false 반환
			if (!isPassed)
				return false;
		}

		return true;
	}
}
