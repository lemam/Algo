import java.util.Scanner;

/*
 * SWEA 6190번 - 정곤이의 단조 증가하는 수 (D3)
 * 
 * 정곤이는 자신이 엄청난 수학자임을 증명하기 위해, 어떤 규칙 만족하는 수를 찾아보기로 했다.
 * 그 규칙은 단조 증가하는 수인데, 각 숫자의 자릿수가 단순하게 증가하는 수를 말한다.
 * 
 * 어떤 k자리 수 X = d1d2…dk 가 d1 ≤ d2 ≤ … ≤ dk 를 만족하면 단조 증가하는 수이다.
 * 예를 들어 111566, 233359는 단조 증가하는 수이고, 12343, 999888은 단조 증가하는 수가 아니다.
 * 
 * 양의 정수 N 개 A1, …, AN이 주어진다.
 * 1 ≤ i < j ≤ N 인 두 i, j에 대해, Ai x Aj값이 단조 증가하는 수인 것들을 구하고 
 * 그 중의 최댓값을 출력하는 프로그램을 작성하라.
 * 
 * 만약 Ai x Aj중에서 단조 증가하는 수가 없다면 -1을 출력한다.
 */

public class SWEA_6190_정곤이의_단조_증가하는_수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 자리 수

			int[] digits = new int[N]; // 자릿수의 배열

			// 배열 입력
			for (int i = 0; i < N; i++)
				digits[i] = sc.nextInt();

			// 단조 증가하는 수 Ai * Aj의 최댓값, 없다면 -1
			int answer = -1;

			// Ai * Aj 순회
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					int number = digits[i] * digits[j]; // Ai * Aj

					// 저장된 최댓값보다 작으면 건너 뛴다.
					if (number <= answer) continue;

					// Ai * Aj가 단조 증가하는 수이면 최댓값을 비교한다.
					if (checkIncrease(number))
						answer = Math.max(answer, number);
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// 단조 증가하는 수인지 반환
	private static boolean checkIncrease(int number) {
		int n = number;
		int prev = Integer.MAX_VALUE; // 이전 자릿수

		while (n != 0) {
			int rem = n % 10; // 현재 자릿수

			// 현재 자릿수가 이전 자릿수보다 크면 단조 증가하는 수가 아니다.
			if (rem > prev) return false;

			prev = rem;
			n /= 10;
		}

		return true;
	}
}
