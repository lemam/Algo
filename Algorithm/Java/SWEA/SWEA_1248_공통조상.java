/*
 * SWEA 1248번 - 공통조상 (D5)
 * 
 * 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고, 
 * 그 정점을 루트로 하는 서브 트리의 크기를 알아내는 프로그램을 작성하라.
 */

import java.util.Scanner;

public class SWEA_1248_공통조상 {
	private static class Node {
		public int parent;
		public int left;
		public int right;

		public Node() {
		}
	}

	public static Node[] nodes; // 정점 노드 배열
	public static boolean[] visited; // 마킹 배열
	public static int ancestor; // 공통 조상
	public static int subTreeSize; // 공통 조상을 루트로 하는 서브 트리의 크기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수
			int N1 = sc.nextInt(); // 공통 조상을 찾는 두 개의 정점 번호 1
			int N2 = sc.nextInt(); // 공통 조상을 찾는 두 개의 정점 번호 2

			nodes = new Node[V + 1];

			// 노드 생성
			for (int i = 1; i <= V; i++) {
				nodes[i] = new Node();
			}

			// 트리 생성
			for (int i = 0; i < E; i++) {
				int parent = sc.nextInt(); // 부모 노드 번호
				int child = sc.nextInt(); // 자식 노드 번호

				// 자식 노드 연결
				if (nodes[parent].left == 0)
					nodes[parent].left = child;
				else
					nodes[parent].right = child;

				// 부모 노드 연결
				nodes[child].parent = parent;
			}

			visited = new boolean[V + 1];
			ancestor = 1;
			subTreeSize = 0;

			// N1과 N2의 공통 조상 찾기
			findAncestor(N1);
			findAncestor(N2);

			// 공통 조상을 루트로 하는 서브 트리의 크기 저장
			getSubTreeSize(nodes[ancestor]);

			System.out.printf("#%d %d %d\n", tc, ancestor, subTreeSize);
		}

		sc.close();
	}

	// 공통 조상 찾기
	// 공통 조상을 찾고자 하는 정점에서 부모 노드를 따라 찾아가며 마킹한다.
	// 또 다른 정점의 탐색 과정에서 이미 마킹된 부모 노드를 만났다면 그 노드가 공통 조상이다.
	private static void findAncestor(int num) {
		int curr = num;

		while (curr > 1) {
			int parent = nodes[curr].parent;

			// 마킹한 부모 노드이면 공통 조상이다.
			if (visited[parent]) {
				ancestor = parent;
				break;
			}

			visited[parent] = true;
			curr = parent;
		}
	}

	// 공통 조상을 루트로 하는 서브 트리의 크기를 센다.
	private static void getSubTreeSize(Node node) {
		subTreeSize++;
		if (nodes[node.left] != null)
			getSubTreeSize(nodes[node.left]);
		if (nodes[node.right] != null)
			getSubTreeSize(nodes[node.right]);
	}
}
