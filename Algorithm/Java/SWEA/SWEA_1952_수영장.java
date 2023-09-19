import java.util.Scanner;

/*
 * SWEA 1952번 - 수영장
 * 
 * 김 프로는 수영장을 이용한다.
 * 김 프로는 지출이 너무 많아 내년 1년 동안 각 달의 이용 계획을 수립하고 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 있다.
 * 
 * 수영장에서 판매하고 있는 이용권은 아래와 같이 4 종류이다.
 * 1. 1일 이용권 : 1일 이용이 가능하다.
 * 2. 1달 이용권 : 1달 동안 이용이 가능하다. 1달 이용권은 매달 1일부터 시작한다.
 * 3. 3달 이용권 : 연속된 3달 동안 이용이 가능하다. 3달 이용권은 매달 1일부터 시작한다.
 * (11월, 12월에도 3달 이용권을 사용할 수 있다.
 * 다음 해의 이용권만을 구매할 수 있기 때문에 3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할 수는 없다.)
 * 4. 1년 이용권 : 1년 동안 이용이 가능하다. 1년 이용권은 매년 1월 1일부터 시작한다.
 * 
 * 각 달의 이용 계획은 [Table 1]의 형태로 수립된다.
 * 이용 계획에 나타나는 숫자는 해당 달에 수영장을 이용할 날의 수를 의미한다.
 * 
 * 각 이용권의 요금과 각 달의 이용 계획이 입력으로 주어질 때,
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 정답으로 출력하는 프로그램을 작성하라.
 */

public class SWEA_1952_수영장 {
	public static int[] cost; // 이용권의 요금 배열 (1일, 1달, 3달, 1년)
	public static int[] plan; // 12개월 이용 계획 배열

	public static int answer; // 최소 지출 비용

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			cost = new int[4]; 
			plan = new int[13]; 

			// 이용권의 요금 배열 입력
			for (int i = 0; i < 4; i++) {
				cost[i] = sc.nextInt();
			}

			// 12개월 이용 계획 배열 입력
			for (int i = 1; i < 13; i++) {
				plan[i] = sc.nextInt();
			}

			// 1년 이용권으로 이용할 경우
			answer = cost[3];

			// 모든 경우의 수 탐색
			dfs(1, 0);

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	public static void dfs(int month, int total) {
		// 총합이 최소 비용의 값을 넘어버리면 중단한다.
		if (total > answer)	return;

		if (month > 12) {
			answer = Math.min(answer, total);
			return;
		}

		// 이용하지 않을 때는 이용권을 사지 않는다.
		if (plan[month] == 0) {
			dfs(month + 1, total);
		} else {
			// 1일 이용권을 이용하는 경우
			dfs(month + 1, total + plan[month] * cost[0]);

			// 1달 이용권을 이용하는 경우
			dfs(month + 1, total + cost[1]);

			// 3달 이용권을 이용하는 경우
			dfs(month + 3, total + cost[2]);
		}
	}
}
