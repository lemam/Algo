import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 백준 1197번 - 최소 스패닝 트리 (골드 4)
 * 
 * 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
 * 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
 * 
 * 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 
 * 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. 
 * C는 음수일 수도 있으며, 절댓값이 1,000,000을 넘지 않는다.
 * 
 * 그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 
 */

public class BOJ_1197_최소_스패닝_트리 {
	private static class Edge {
		int a, b, v;

		public Edge(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}
	}

	private static int p[]; // 대표를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		List<Edge> edgeList = new ArrayList<>();

		// 간선 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			// 인접한 두 정점의 번호
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// 가중치
			int C = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(A, B, C));
		}

		// 크루스칼 알고리즘
		// 1. 간선의 가중치를 기준으로 오름차순으로 정렬
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.v - o2.v;
			}
		});

		// 2. 집합 생성
		p = new int[V + 1];

		for (int i = 1; i <= V; i++)
			p[i] = i;

		int answer = 0; // 최소 비용
		int pick = 0; // 뽑은 간선의 개수

		// 3. 가중지가 가장 낮은 간선부터 V-1개를 뽑는다.
		// 사이클이 발생하지 않도록 한다.
		for (int i = 0; i < E; i++) {
			Edge edge = edgeList.get(i); // i번째 간선
			int x = edge.a;
			int y = edge.b;

			// 사이클이 아니면(같은 집합이 아니면) 합친다.
			if (findset(x) != findset(y)) {
				union(x, y);
				answer += edgeList.get(i).v;
				pick++;
			}

			if (pick == V - 1)
				break;
		}

		System.out.println(answer);

		br.close();
	}

	private static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	private static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);

		return p[x];
	}
}
