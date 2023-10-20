import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1991번 - 트리 순회 (실버 1)
 * 
 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * 
 * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
 * 자식 노드가 없는 경우에는 .으로 표현한다.
 * 
 * 첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 
 * 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */

public class BOJ_1991_트리_순회 {
	private static class Node {
		char value;
		int left, right;

		public Node() {
		}
	}

	private static Node[] nodeArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 노드의 개수

		nodeArr = new Node[N]; // 노드 배열

		for (int i = 0; i < N; i++)
			nodeArr[i] = new Node();

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");

			// 노드 입력
			// 알파벳 순서에 맞춰 넣는다.
			char value = input[0].charAt(0);
			int idx = value - 'A';

			nodeArr[idx].value = value;

			// 왼쪽 자식 노드 입력
			if (!input[1].equals("."))
				nodeArr[idx].left = input[1].charAt(0) - 'A';

			// 오른쪽 자식 노드 입력
			if (!input[2].equals("."))
				nodeArr[idx].right = input[2].charAt(0) - 'A';
		}

		preorder(0); // 전위 순회
		System.out.println();

		inorder(0); // 중위 순회
		System.out.println();

		postorder(0); // 후위 순회

		br.close();
	}

	// 후위 순회
	private static void postorder(int i) {
		if (nodeArr[i].left > 0)
			postorder(nodeArr[i].left);

		if (nodeArr[i].right > 0)
			postorder(nodeArr[i].right);

		System.out.print(nodeArr[i].value);
	}

	// 중외 순회
	private static void inorder(int i) {
		if (nodeArr[i].left > 0)
			inorder(nodeArr[i].left);

		System.out.print(nodeArr[i].value);

		if (nodeArr[i].right > 0)
			inorder(nodeArr[i].right);
	}

	// 전위 순회
	private static void preorder(int i) {
		System.out.print(nodeArr[i].value);

		if (nodeArr[i].left > 0)
			preorder(nodeArr[i].left);

		if (nodeArr[i].right > 0)
			preorder(nodeArr[i].right);
	}
}
