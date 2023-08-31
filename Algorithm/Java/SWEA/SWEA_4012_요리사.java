import java.util.Scanner;

/*
 * SWEA 4012번 - 요리사
 * 
 * 두 명의 손님에게 음식을 제공하려고 한다.
 * 두 명의 손님은 식성이 비슷하기 때문에, 최대한 비슷한 맛의 음식을 만들어 내야 한다.
 * 
 * N개의 식재료가 있다.
 * 식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다. (N은 짝수이다.)
 * 이때, 각각의 음식을 A음식, B음식이라고 하자.
 * 
 * 비슷한 맛의 음식을 만들기 위해서는 A음식과 B음식의 맛의 차이가 최소가 되도록 재료를 배분해야 한다.
 * 음식의 맛은 음식을 구성하는 식재료들의 조합에 따라 다르게 된다.
 * 
 * 식재료 i는 식재료 j와 같이 요리하게 되면 궁합이 잘 맞아 시너지 Sij가 발생한다. 
 * (1 ≤ i ≤ N, 1 ≤ j ≤ N, i ≠ j)
 * 각 음식의 맛은 음식을 구성하는 식재료들로부터 발생하는 시너지 Sij들의 합이다.
 * 
 * 식재료 i를 식재료 j와 같이 요리하게 되면 발생하는 시너지 Sij의 정보가 주어지고, 
 * 가지고 있는 식재료를 이용해 A음식과 B음식을 만들 때, 
 * 두 음식 간의 맛의 차이가 최소가 되는 경우를 찾고 그 최솟값을 정답으로 출력하는 프로그램을 작성하라.
 * 
 * 정답은 두 음식 간의 맛의 차이가 최소가 되도록 A음식과 B음식을 만들었을 때 그 차이 값이다.
 */

public class SWEA_4012_요리사 {
	public static int N; // 식재료의 수
	public static int[][] S; // 시너지 배열
	public static boolean[] sel; // 선택한 조합을 저장하는 배열
	public static int min; // 두 요리의 맛의 차의 최솟값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 식재료의 수
			S = new int[N][N]; // 시너지 배열

			// 시너지 배열 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}

			sel = new boolean[N];
			min = Integer.MAX_VALUE;

			combination(N, N / 2);

			System.out.printf("#%d %d\n", tc, min);
		}

		sc.close();
	}

	// 식재료 조합 구하기
	private static void combination(int n, int r) {
		if (r == 0) {
			// 두 요리의 맛의 차의 최솟값
			min = Math.min(min, calcDiff());
			return;
		}

		if (n < r) return;

		sel[n - 1] = true;
		combination(n - 1, r - 1);
		sel[n - 1] = false;
		combination(n - 1, r);
	}

	// A의 음식의 맛과 B의 음식의 맛의 차를 반환한다.
	private static int calcDiff() {
		int foodA = 0;
		int foodB = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sel[i] && sel[j]) {
					foodA += S[i][j];
				} else if (!sel[i] && !sel[j]) {
					foodB += S[i][j];
				}
			}
		}

		return Math.abs(foodA - foodB);
	}
}
