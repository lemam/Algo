package SWEA;

import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 1222번 - 계산기1 (D4)
 * 
 * 문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
 * 문자열 계산식을 구성하는 연산자는 + 하나뿐이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
 */

public class SWEA_1222_계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;	// 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int len = sc.nextInt();	// 문자열의 길이
			char[] infix = sc.next().toCharArray();	// 중위 표기식 배열

			// 중위 표기식 -> 후위 표기식
			Stack<Character> inStack = new Stack<>();
			char[] postfix = new char[len];	// 후위 표기식 배열
			int idx = 0; // postfix가 가리키는 인덱스

			for (int i = 0; i < len; i++) {
				// 토큰이 피연산자이면 배열에 저장
				if (infix[i] != '+') {
					postfix[idx++] = infix[i];
					continue;
				}

				// 토큰이 연산자이면,
				// 스택이 비어있으면 스택에 토큰을 넣는다.
				if (inStack.isEmpty()) {
					inStack.push(infix[i]);
				} else {
					// 스택 안에 + 연산자가 들어있다면
					// 스택을 전부 pop하고 출력한 후 토큰을 push한다.
					while (!inStack.isEmpty()) {
						postfix[idx++] = inStack.pop();
					}
					
					inStack.push(infix[i]);
				}
			}
			
			// 스택에 남아 있는 것들을 전부 저장한다.
			while (!inStack.isEmpty()) {
				postfix[idx++] = inStack.pop();
			}
			
			// 후위 표기식 -> 계산
			Stack<Integer> postStack = new Stack<>();
			
			for (int i = 0; i < len; i++) {
				// 연산자가 아니면 스택에 토큰을 넣는다.
				if (postfix[i] != '+') {
					postStack.push(postfix[i] - '0');
					continue;
				}
				
				// 연산자이면 스택에서 2개의 피연산자를 꺼내 연산한다.
				int B = postStack.pop();
				int A = postStack.pop();
				int C = A + B;
				
				// 계산한 값을 stack에 다시 넣는다.
				postStack.push(C);
			}
			
			// 스택에 남은 값을 출력한다.
			System.out.printf("#%d %d\n", tc, postStack.pop());
		}

		sc.close();
	}
}
