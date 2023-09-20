import java.util.Scanner;

/*
 * SWEA 7465번 - 창용 마을 무리의 개수 (D4)
 * 
 * 창용 마을에는 N명의 사람이 살고 있다.
 * 사람은 편의상 1번부터 N번 사람까지 번호가 붙어져 있다고 가정한다.
 * 
 * 두 사람은 서로를 알고 있는 관계일 수 있고, 아닐 수 있다.
 * 두 사람이 서로 아는 관계이거나 몇 사람을 거쳐서 알 수 있는 관계라면,
 * 이러한 사람들을 모두 다 묶어서 하나의 무리라고 한다.
 * 
 * 창용 마을에 몇 개의 무리가 존재하는지 계산하는 프로그램을 작성하라.
 */

public class SWEA_7465_창용_마을_무리의_개수 {
	public static int[] p; // 각 사람들이 속한 무리를 저장한 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 창용 마을에 사는 사람의 수
			int M = sc.nextInt(); // 서로를 알고 있는 사람의 관계 수

			p = new int[N + 1];

			// 무리 배열 초기화
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}

			// 모든 관계 탐색
			for (int i = 0; i < M; i++) {
				// 서로 알고 있는 두 사람의 번호
				int x = sc.nextInt();
				int y = sc.nextInt();

				// 무리를 합친다.
				union(findset(x), findset(y));
			}

			int[] count = new int[N + 1]; // 무리 개수 카운트 배열
			int answer = 0; // 무리의 개수

			// 무리 개수 넣기
			for (int i = 1; i <= N; i++) {
				count[findset(i)]++;
			}

			// 무리 개수 세기
			for (int i = 1; i <= N; i++) {
				if (count[i] > 0) {
					answer++;
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	public static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}
}
