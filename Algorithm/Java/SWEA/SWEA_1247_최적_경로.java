import java.util.Scanner;

/*
 * SWEA 1247번 - 최적 경로 (D5)
 * 
 * 삼성전자의 서비스 기사인 김대리는 회사에서 출발하여 냉장고 배달을 위해 N명의 고객을 방문하고 자신의 집에 돌아가려한다.
 * 
 * 회사와 집의 위치, 그리고 각 고객의 위치는 이차원 정수 좌표 (x, y)로 주어지고 
 * 두 위치 (x1, y1)와 (x2, y2) 사이의 거리는 |x1-x2| + |y1-y2|으로 계산된다.
 * 회사의 좌표, 집의 좌표, 고객들의 좌표는 모두 다르다.
 * 
 * 회사에서 출발하여 N명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 것을 찾으려 한다.
 * 
 * 회사와 집의 좌표가 주어지고, 2명에서 10명 사이의 고객 좌표가 주어질 때, 
 * 회사에서 출발해서 이들을 모두 방문하고 집에 돌아가는 경로 중 총 이동거리가 가장 짧은 경로를 찾는 프로그램을 작성하라.
 */

public class SWEA_1247_최적_경로 {
	static class Pos {
		int x, y; // x, y 좌표

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getDistance(Pos other) {
			return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
		}
	}

	public static int N; // 고객의 수
	public static Pos company; // 회사의 좌표
	public static Pos home; // 집의 좌표
	public static Pos[] customers; // 고객의 좌표 배열
	public static boolean[] visited; // 고객 방문 여부 확인 배열
	public static int answer; // 최단 경로의 이동거리

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = sc.nextInt();
			company = new Pos(sc.nextInt(), sc.nextInt());
			home = new Pos(sc.nextInt(), sc.nextInt());

			customers = new Pos[N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				customers[i] = new Pos(sc.nextInt(), sc.nextInt());
			}

			answer = Integer.MAX_VALUE;

			// 모든 경로 확인하기
			powerset(0, 0, company);

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// depth : 현재 깊이
	// dist : 현재 이동한 거리
	// cur : 현재 위치 좌표
	public static void powerset(int depth, int dist, Pos cur) {
		// 모든 고객을 방문했으면
		if (depth == N) {
			// 집으로 돌아간다.
			dist += cur.getDistance(home);
			// 최솟값인지 확인한다.
			answer = Math.min(answer, dist);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])	continue;

			visited[i] = true;
			powerset(depth + 1, dist + cur.getDistance(customers[i]), customers[i]);
			visited[i] = false;
		}
	}
}
