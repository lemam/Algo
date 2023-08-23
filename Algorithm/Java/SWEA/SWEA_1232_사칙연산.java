import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 1232번 - 사칙연산 (D4)
 * 
 * 사칙연산으로 구성되어 있는 식은 이진 트리로 표현할 수 있다.
 * 임의의 정점에 연산자가 있으면 해당 연산자의 왼쪽 서브 트리의 결과와 오른쪽 서브 트리의 결과에 해당 연산자를 적용한다.
 * 
 * 사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이를 계산한 결과를 출력하는 프로그램을 작성하라.
 * 계산 중간 과정에서의 연산은 모두 실수 연산으로 한다.
 * 
 * 정점이 정수면 정점 번호와 양의 정수가 주어지고, 정점이 연산자이면 정점 번호, 연산자, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점 번호가 차례대로 주어진다.
 * 정점 번호는 1부터 N까지의 정수로 구분되고 루트 정점의 번호는 항상 1이다.
 */


public class SWEA_1232_사칙연산 {
	static class Node {
		String data; // 데이터
		int left; // 왼쪽 자식 노드 번호
		int right; // 오른쪽 자식 노드 번호

		public Node() {
		}

		public Node(String data) {
			this.data = data;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public void setRight(int right) {
			this.right = right;
		}
	}

	
	public static Node[] tree;
	public static int N;
	public static Stack<String> stack;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;	// 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(sc.nextLine()); // 정점의 개수
			tree = new Node[N + 1];
			stack = new Stack<>();

			// 트리 입력
			for (int i = 0; i < N; i++) {
				String[] str = sc.nextLine().split(" ");

				int num = Integer.parseInt(str[0]); // 정점 번호
				String data = str[1]; // 정점 데이터

				// 노드 생성
				Node node = new Node(data);

				// 자식 노드 번호 넣기
				if (str.length >= 3) {
					node.setLeft(Integer.parseInt(str[2])); // 왼쪽

					if (str.length == 4)
						node.setRight(Integer.parseInt(str[3])); // 오른쪽
				}

				// 트리 배열에 노드 넣기
				tree[num] = node;
			}

			postorder(1);

			System.out.printf("#%d %s\n", tc, stack.pop());
		}

		sc.close();
	}

	// 후위 순회
	public static void postorder(int i) {
		if (i <= N) {
			Node node = tree[i];

			if (tree[node.left] != null)
				postorder(node.left); // L

			if (tree[node.right] != null)
				postorder(node.right); // R

			// V
			// 연산자이면 스택에서 두 개의 값을 꺼내 연산한 후 다시 스택에 넣는다.
			if (node.data.equals("+")) {
				int B = Integer.parseInt(stack.pop());
				int A = Integer.parseInt(stack.pop());

				stack.push(Integer.toString(A + B));
			} else if (node.data.equals("-")) {
				int B = Integer.parseInt(stack.pop());
				int A = Integer.parseInt(stack.pop());

				stack.push(Integer.toString(A - B));
			} else if (node.data.equals("*")) {
				int B = Integer.parseInt(stack.pop());
				int A = Integer.parseInt(stack.pop());

				stack.push(Integer.toString(A * B));
			} else if (node.data.equals("/")) {
				int B = Integer.parseInt(stack.pop());
				int A = Integer.parseInt(stack.pop());

				stack.push(Integer.toString(A / B));
			} 
			// 피연산자이면 스택에 넣는다.
			else {
				stack.push(node.data);
			}
		}
	}
}
