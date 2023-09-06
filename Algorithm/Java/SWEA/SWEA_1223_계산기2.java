/*
 * SWEA 1233번 - 계산기2 (D4)
 * 
 * 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
 * 문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
 */

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223_계산기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int len = sc.nextInt(); // 테스트 케이스 길이
			String str = sc.next(); // 테스트 케이스

			Stack<Character> stack = new Stack<Character>();
			char[] postfix = new char[len];
			int idx = 0;

			// 계산식 -> 후위 표기식
			for (int i = 0; i < len; i++) {
				char token = str.charAt(i);

				// 1. 토큰이 피연산자인 경우
				if (token != '+' && token != '*') {
					// 배열에 저장한다.
					postfix[idx++] = token;
					continue;
				}

				// 2. 토큰이 연산자인 경우
				// 스택이 비어있으면 토큰을 스택에 넣는다.
				if (stack.isEmpty()) {
					stack.push(token);
					continue;
				}

				// 스택 안에 값이 있으면 토큰과 우선순위를 비교한다.
				// 스택이 비거나 나보다 우선순위가 높은 연산자를 만날 때까지 pop한다.
				// 이후 토큰을 스택에 넣는다.
				if (token == '+') {
					while (!stack.isEmpty()) {
						postfix[idx++] = stack.pop();
					}
					stack.push(token);
				} else if (token == '*') {
					while (!stack.isEmpty()) {
						if (stack.peek() == '+') break;
						postfix[idx++] = stack.pop();
					}
					stack.push(token);
				}
			}

			// 스택에 남아있는 인자들을 스택에 넣는다.
			while (!stack.isEmpty()) {
				postfix[idx++] = stack.pop();
			}

			Stack<Integer> calcStack = new Stack<Integer>();

			// 후위 표기식 계산
			for (int i = 0; i < idx; i++) {
				char token = postfix[i];

				// 1. 토큰이 피연산자인 경우
				if (token != '+' && token != '*') {
					// 스택에 넣는다.
					calcStack.push(Character.getNumericValue(token));
					continue;
				}

				// 2. 토큰이 연산자인 경우 
				// 스택에서 두 개의 인자를 꺼내 계산하고 그 값을 스택에 넣는다.
				int b = calcStack.pop();
				int a = calcStack.pop();

				if (token == '+')
					calcStack.push(a + b);
				else if (token == '*')
					calcStack.push(a * b);
			}

			// 스택에 남아 있는 계산 결과값을 출력한다.
			System.out.printf("#%d %d\n", tc, calcStack.pop());
		}

		sc.close();
	}
}
