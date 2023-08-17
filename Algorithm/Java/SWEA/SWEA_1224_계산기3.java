import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 1224번 - 계산기1 (D4)
 * 
 * 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
 * 
 * 문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어갈 수 있다.
 * 이 때 괄호의 유효성 여부는 항상 옳은 경우만 주어진다.
 * 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
 */

public class SWEA_1224_계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10; // 테스트 케이스

		// 스택 안에서의 연산자 우선순위 Map - 값이 클 수록 우선순위가 높다.
		Map<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);

		for (int tc = 1; tc <= T; tc++) {
			int len = sc.nextInt(); // 문자열의 길이
			char[] infix = sc.next().toCharArray(); // 중위 표기식 배열

			// 중위 표기식 -> 후위 표기식
			Stack<Character> inStack = new Stack<>();
			char[] postfix = new char[len]; // 후위 표기식 배열
			int idx = 0; // postfix가 가리키는 인덱스

			for (int i = 0; i < len; i++) {
				// 1. 토근이 닫힌 괄호이면 열린괄호를 만날 때까지 스택에서 꺼낸 배열에 저장한다.
				if (infix[i] == ')') {
					while (inStack.peek() != '(') {
						postfix[idx++] = inStack.pop();
					}

					// 열린 괄호는 삭제한다.
					inStack.pop();
					continue;
				}

				// 2. 토큰이 피연산자이면 배열에 저장
				if (!priority.containsKey(infix[i])) {
					postfix[idx++] = infix[i];
					continue;
				}

				// 3. 열린 괄호는 스택 밖에서 최우선순위이므로 그냥 스택에 넣는다.
				if (infix[i] == '(') {
					inStack.push(infix[i]);
					continue;
				}

				// 4. 토큰이 연산자일 경우
				// 스택의 top의 우선순위가 토큰보다 낮을 때까지 스택에서 꺼내 배열에 저장한다.
				while (!inStack.isEmpty()) {
					if (priority.get(inStack.peek()) < priority.get(infix[i])) {
						break;
					}

					postfix[idx++] = inStack.pop();
				}

				// 토큰을 스택에 넣는다.
				inStack.push(infix[i]);
			}

			// 스택에 남아 있는 것들을 전부 저장한다.
			while (!inStack.isEmpty()) {
				postfix[idx++] = inStack.pop();
			}

			// 후위 표기식 -> 계산
			Stack<Integer> postStack = new Stack<>();

			for (int i = 0; i < len; i++) {
				// 읽을 토큰이 없으면 중지한다.
				if (postfix[i] == '\u0000') {
					break;
				}

				// 1. 피연산자이면 스택에 넣는다.
				if (!priority.containsKey(postfix[i])) {
					postStack.push(postfix[i] - '0');
					continue;
				}

				// 2. 연산자이면 스택에서 2개의 피연산자를 꺼내 계산한다.
				int B = postStack.pop();
				int A = postStack.pop();
				int C = 0;

				switch (postfix[i]) {
				case '+':
					C = A + B;
					break;
				case '-':
					C = A - B;
					break;
				case '*':
					C = A * B;
					break;
				case '/':
					C = A / B;
					break;
				default:
					break;
				}

				// 계산한 값을 스택에 다시 넣는다.
				postStack.push(C);
			}

			// 스택에 남은 결과값을 출력한다.
			System.out.printf("#%d %d\n", tc, postStack.pop());
		}

		sc.close();
	}
}
