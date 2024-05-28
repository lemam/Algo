package SWEA;

import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 1218번 - 괄호 짝짓기 (D4)
 * 
 * 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
 * 이 문자열에 사용된 괄호들의 짝이 모두 맞는지 판별하는 프로그램을 작성한다.
 * 유효성 여부를 1 또는 0으로 표시한다 (1 - 유효함, 0 - 유효하지 않음).
 */

public class SWEA_1218_괄호_짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트 케이스
		char[] openBrackets = { '(', '[', '{', '<' }; // 여는 괄호
		char[] closeBrackets = { ')', ']', '}', '>' }; // 닫는 괄호

		for (int tc = 1; tc <= T; tc++) {
			int len = sc.nextInt();
			String str = sc.next();

			Stack<Character> stack = new Stack<>();
			int answer = 1;

			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);

				// 여는 괄호를 만나면 stack에 넣는다.
				if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
					stack.push(ch);
					continue;
				}
				
				// 닫는 괄호를 만나면 stack에 짝이 있는지 확인한다.
				// 닫는 괄호가 여는 괄호보다 오른쪽에 있으면 유효하지 않다.
				if (stack.isEmpty()) {
					answer = 0;
					break;
				}

				int idx = 0;

				// ch가 closeBrackets의 몇 번째 요소인지 찾기
				for (int j = 0; j < closeBrackets.length; j++) {
					if (ch == closeBrackets[j]) {
						idx = j;
						break;
					}
				}

				// 짝이 맞지 않는 괄호가 사용되면 유효하지 않다.
				if (stack.pop() != openBrackets[idx]) {
					answer = 0;
					break;
				}
			}

			// 괄호의 짝을 찾을 수 없으면 유효하지 않다.
			if (answer == 1 && !stack.isEmpty())
				answer = 0;

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
