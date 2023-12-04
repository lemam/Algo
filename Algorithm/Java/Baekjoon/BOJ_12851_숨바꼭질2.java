import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
	private static int N, K;
	private static int[] visited;
	private static int minTime, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		K = Integer.parseInt(st.nextToken()); // 동생의 위치

		visited = new int[100001];
		minTime = 987654321;
		count = 0;
		
		// 수빈이의 시작 위치가 동생보다 크다면 무조건 -1을 반복하므로
		// N-K를 출력한다.
		if (N >= K) {
			System.out.println((N-K) + "\n" + "1");
			return;
		}

		bfs();

		System.out.println(minTime + "\n" + count);

		br.close();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(N);
		visited[N] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			// 현재 방문 시간이 최소 시간보다 크면 보지 않는다.
			if (minTime < visited[now])
				return;

			for (int i = 0; i < 3; i++) {
				int next = 0;

				// X + 1
				if (i == 0)
					next = now + 1;
				// X - 1
				else if (i == 1)
					next = now - 1;
				// X * 2
				else
					next = now * 2;

				// 범위 밖이면 스킵한다.
				if (next < 0 || next > 100000)
					continue;

				if (next == K) {
					minTime = visited[now];
					count++;
				}

				// 첫 방문이거나
				// 이전 방문 시간과 현재 방문 시간이 일치할 때
				// 큐에 넣어준다.
				if (visited[next] == 0 || visited[next] == visited[now] + 1) {
					queue.add(next);
					visited[next] = visited[now] + 1;
				}
			}
		}
	}
}
