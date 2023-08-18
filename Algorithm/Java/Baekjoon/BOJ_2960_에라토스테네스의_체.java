import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2960번 - 에라토스테네스의 체 (실버 4)
 * 
 * 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
 * 
 * 이 알고리즘은 다음과 같다.
 * 1. 2부터 N까지 모든 정수를 적는다.
 * 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
 * 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 * 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 * 
 * N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
 */

public class BOJ_2960_에라토스테네스의_체 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int P = 2; // 지우지 않은 수 중 가장 작은 수
		int cnt = 0; // 지운 횟수

		boolean[] arr = new boolean[N + 1];

		// 2부터 N까지 모든 정수를 적는다.
		for (int i = 2; i <= N; i++) {
			arr[i] = true;
		}

		outer: while (true) {
			// P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
			for (int i = P; i <= N; i++) {
				if (!arr[i]) continue;
				
				// i가 P의 배수이면
				if (i % P == 0) {
					// i가 K번째 지우는 수라면 출력하고 탐색을 중지한다.
					if (++cnt == K) {
						System.out.println(i);
						break outer;
					}

					// i 지우기
					arr[i] = false;
				}
			}

			// 지우지 않은 수 중 가장 작은 수 찾기
			for (int i = 2; i <= N; i++) {
				if (arr[i]) {
					P = i;
					break;
				}
			}
		}

		br.close();
	}
}
