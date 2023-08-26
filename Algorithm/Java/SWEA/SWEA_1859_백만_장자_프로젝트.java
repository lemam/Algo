import java.util.Scanner;

/*
 * SWEA 1859번 - 백만 장자 프로젝트 (D2)
 * 
 * 25년 간의 수행 끝에 원재는 미래를 보는 능력을 갖게 되었다. 
 * 이 능력으로 원재는 사재기를 하려고 한다.
 * 다만 당국의 감시가 심해 한 번에 많은 양을 사재기 할 수 없다.
 *
 * 다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.
 * 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
 * 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다. (1개 구매 가능)
 * 3. 판매는 얼마든지 할 수 있다.
 */

public class SWEA_1859_백만_장자_프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N]; // N일 동안의 매매가 배열

			int max = 0; // 최대 매매가
			long answer = 0; // 최대 이익

			// 배열 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 뒤에서부터 탐색
			for (int i = N - 1; i >= 0; i--) {
				// 현재 매매가가 최대 매매가보다 크면 갱신한다.
				if (max < arr[i])
					max = arr[i];
				// 매매가가 최대 매매가보다 낮으면 팔고 이익을 더한다.
				else
					answer += max - arr[i];
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
