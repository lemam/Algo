package SWEA;

import java.io.IOException;
import java.util.Scanner;

/*
 * SWEA 1248번 - 공통조상 (D5)
 * 
 * 이진 트리에서 임의의 두 정점의 가장 가까운 공통 조상을 찾고, 
 * 그 정점을 루트로 하는 서브 트리의 크기를 알아내는 프로그램을 작성하라.
 * 
 * 정점의 번호는 1부터 V까지의 정수이며, 루트 정점은 항상 1번이다.
 * 가장 가까운 공통 조상의 번호와 그것을 루트로 하는 서브 트리의 크기를 공백으로 구분하여 출력하라.
 */

public class SWEA_1248_공통조상 {
	private static class Node {
		int parent, left, right;

		public Node() {
		}
	}

	private static Node[] nodeArr;
	private static int ancestor, subTreeSize;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt(); // 정점의 개수
			int E = sc.nextInt(); // 간선의 개수

			// 공통 조상을 찾는 두 개의 정점 번호
			int A = sc.nextInt();
			int B = sc.nextInt();

			nodeArr = new Node[V + 1]; // 트리 배열

			// 트리 배열 초기화
			for (int i = 0; i < V + 1; i++)
				nodeArr[i] = new Node();

			// 정점 입력
			for (int i = 0; i < E; i++) {
				int pNum = sc.nextInt(); // 부모 정점 번호
				int cNum = sc.nextInt(); // 자식 정점 번호
				
				// 자식 노드 연결
				if (nodeArr[pNum].left == 0)
					nodeArr[pNum].left = cNum;
				else
					nodeArr[pNum].right = cNum;

				// 부모 노드 연결
				nodeArr[cNum].parent = pNum;
				
			}
			
			boolean[] visited = new boolean[V + 1]; // 노드 방문 배열
			ancestor = 0; // 공통 조상 정점의 번호
			subTreeSize = 0; // 공통 조상을 루트로 하는 서브 트리의 크기

			findAncestor(A, visited);
			findAncestor(B, visited);
			
			getSubTreeSize(nodeArr[ancestor]);
			
			System.out.printf("#%d %d %d\n", tc, ancestor, subTreeSize);
		}

		sc.close();
	}

	// node : 시작 노드
	// node를 root로 하는 서브 트리를 순회하며 정점의 개수를 subTreeSize에 저장한다.
	private static void getSubTreeSize(Node node) {
		subTreeSize++;
		
		if (node.left != 0)
			getSubTreeSize(nodeArr[node.left]);
		
		if (node.right != 0)
			getSubTreeSize(nodeArr[node.right]);
	}

	private static void findAncestor(int n, boolean[] visited) {
		int child = n;

		while (child > 1) {
			int parent = nodeArr[child].parent;

			// 이미 방문한 정점이라면 이 정점이 공통조상이다.
			if (visited[parent]) {
				ancestor = parent;
				break;
			}

			visited[parent] = true;
			child = parent;
		}
	}

}
