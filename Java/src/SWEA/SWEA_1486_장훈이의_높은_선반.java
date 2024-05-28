package SWEA;

import java.util.Scanner;

/*
 * SWEA 1486번 - 장훈이의 높은 선반 (D4)
 * 
 * 장훈이는 서점을 운영하고 있다.
 * 서점에는 높이가 B인 선반이 하나 있는데 장훈이는 키가 매우 크기 때문에, 선반 위의 물건을 자유롭게 사용할 수 있다.
 * 
 * 어느 날 장훈이는 자리를 비웠고, 이 서점에 있는 N명의 점원들이 장훈이가 선반 위에 올려놓은 물건을 사용해야 하는 일이 생겼다.
 * 각 점원의 키는 Hi로 나타나는데, 점원들은 탑을 쌓아서 선반 위의 물건을 사용하기로 하였다.
 * 점원들이 쌓는 탑은 점원 1명 이상으로 이루어져 있다.
 * 탑의 높이는 점원이 1명일 경우 그 점원의 키와 같고, 2명 이상일 경우 탑을 만든 모든 점원의 키의 합과 같다.
 * 
 * 탑의 높이가 B 이상인 경우 선반 위의 물건을 사용할 수 있는데 
 * 탑의 높이가 높을수록 더 위험하므로 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑을 알아내려고 한다.
 * 
 * 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이가 가장 작은 것을 출력한다.
 */

public class SWEA_1486_장훈이의_높은_선반 {
	public static int N; // 점원의 수
	public static int B; // 선반의 높이
	public static int[] H; // 점원의 키 배열
	public static int answer; // 만들 수 있는 높이가 B 이상인 탑 중에서 탑의 높이와 B의 차이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = sc.nextInt();
			B = sc.nextInt();

			H = new int[N];

			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
			}

			answer = Integer.MAX_VALUE;

			// 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑의 높이와 B의 차가 가장 작은 것 찾기
			powerset(0, 0);
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// depth : 현재 깊이
	// sum : 선택한 점원들의 키의 합
	public static void powerset(int depth, int sum) {
		// 모든 점원을 확인했으면
		if (depth == N) {
			// 키의 합이 B 이상이면 최솟값인지 확인한다.
			if (sum >= B) {
				answer = Math.min(answer, sum - B);
			}
			return;
		}

		// 점원을 선택할 경우
		powerset(depth + 1, sum + H[depth]);
		// 점원을 선택하지 않을 경우
		powerset(depth + 1, sum);
	}
}
