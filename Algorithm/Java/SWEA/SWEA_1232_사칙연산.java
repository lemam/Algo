/*
 * SWEA 1232번 - 사칙연산 (D4)
 * 
 * 사칙연산으로 구성되어 있는 식은 이진 트리로 표현할 수 있다. 
 * 아래는 식 “(9/(6-4))*3”을 이진 트리로 표현한 것이다.
 * 임의의 정점에 연산자가 있으면 해당 연산자의 왼쪽 서브 트리의 결과와 오른쪽 서브 트리의 결과에 해당 연산자를 적용한다.
 * 
 * 사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 
 * 이를 계산한 결과를 출력하는 프로그램을 작성하라.
 * 계산 중간 과정에서의 연산은 모두 실수 연산으로 한다.
 * 
 * 정점 번호는 1부터 N까지의 정수로 구분된고 루트 정점의 번호는 항상 1이다.
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1232_사칙연산 {
	private static class Node {
		String data;
		int left, right;

		public Node() {
		}
	}

	private static Node[] tree;
	private static Stack<String> stack;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine()); // 정점의 개수
			tree = new Node[N + 1]; // 트리 배열

			// 정점 초기화
			for (int i = 1; i < N + 1; i++) {
				tree[i] = new Node();
			}

			// 정점 입력
			for (int i = 1; i <= N; i++) {
				String[] input = sc.nextLine().split(" ");
				int num = Integer.parseInt(input[0]); // 정점 번호

				tree[num].data = input[1]; // 값

				// data가 연산자이면 왼쪽 자식, 오른쪽 자식의 정점 번호 저장
				if (input.length >= 3) {
					int left = Integer.parseInt(input[2]);
					tree[num].left = left;

					int right = Integer.parseInt(input[3]);
					tree[num].right = right;
				}
			}

			stack = new Stack<>(); // 후위 표기법 계산을 위한 스택

			postorder(1); // 후위 순회

			System.out.printf("#%d %s\n", tc, stack.pop());
		}

		sc.close();
	}

	private static void postorder(int i) {
		Node curr = tree[i];

		if (tree[curr.left] != null)
			postorder(curr.left);

		if (tree[curr.right] != null)
			postorder(curr.right);

		calc(curr); // 계산
	}

	private static void calc(Node node) {
		int A, B;

		// 연산자이면 스택에서 두 개의 값을 꺼내 계산한 후 결과값을 스택에 넣는다.
		switch (node.data) {
		case "+":
			B = Integer.parseInt(stack.pop());
			A = Integer.parseInt(stack.pop());
			stack.push(Integer.toString(A + B));
			break;
		case "-":
			B = Integer.parseInt(stack.pop());
			A = Integer.parseInt(stack.pop());
			stack.push(Integer.toString(A - B));
			break;
		case "*":
			B = Integer.parseInt(stack.pop());
			A = Integer.parseInt(stack.pop());
			stack.push(Integer.toString(A * B));
			break;
		case "/":
			B = Integer.parseInt(stack.pop());
			A = Integer.parseInt(stack.pop());
			stack.push(Integer.toString(A / B));
			break;
		// 양의 정수인 경우 스택에 넣는다.
		default:
			stack.push(node.data);
		}
	}
}
