package SWEA;

import java.util.*;

/*
 * 해야 할 V개의 작업이 있다. 
 * 이들 중에 어떤 작업은 특정 작업이 끝나야 시작할 수 있으며, 이를 선행 관계라 하자.
 * 
 * 이런 작업의 선행 관계를 나타낸 그래프가 주어진다.
 * 이 그래프에서 각 작업은 하나씩의 정점으로 표시되고 선행 관계는 방향성을 가진 간선으로 표현된다.
 * 단, 이 그래프에서 사이클은 존재하지 않는다 (사이클은 한 정점에서 시작해서 같은 정점으로 돌아오는 경로를 말한다).
 * 
 * 김과장은 선행 관계가 주어진 작업군을 한 번에 하나의 작업씩 처리해서 다 끝내려 한다.
 * V개의 작업과 이들 간의 선행 관계가 주어질 때, 일을 끝낼 수 있는 작업 순서를 찾는 프로그램을 작성하라.
 * 가능한 작업 순서가 여러 가지일 경우, 여러분은 이들 중 하나만 제시하면 된다.
 * 
 * 정점의 번호는 1부터 V까지의 정수값을 가지며, 입력에서 이웃한 수는 모두 공백으로 구분된다.
 * 올바른 작업 순서를 공백으로 구분하여 출력한다.
 */

public class SWEA_1267_작업순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = 10; // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");

			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수

			List<Integer>[] adjList = new ArrayList[V + 1]; // 인접 리스트
			int[] degree = new int[V + 1]; // 각 정점의 진입 차수 배열

			for (int i = 0; i < V + 1; i++)
				adjList[i] = new ArrayList<>();

			// 간선 입력
			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				adjList[A].add(B);
				degree[B]++; // 진입차수 증가
			}

			Queue<Integer> queue = new LinkedList<Integer>();

			// 진입차수가 0인 정점를 모두 큐에 넣기
			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0)
					queue.add(i);
			}

			while (!queue.isEmpty()) {
				int work = queue.poll();

				sb.append(work + " ");

				// 연결된 정점들의 간선을 제거한다.
				for (int i = 0; i < adjList[work].size(); i++) {
					int x = adjList[work].get(i); // 정점 번호

					adjList[work].set(i, 0); // 간선 제거
					degree[x]--; // 진입차수 감소

					// 진입차수가 0이면 큐에 넣는다.
					if (degree[x] == 0)
						queue.add(x);
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);

		sc.close();
	}
}
