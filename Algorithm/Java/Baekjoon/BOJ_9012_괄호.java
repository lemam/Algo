/*
 * 백준 9012번 - 괄호 (실버 4)
 * 
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 
 * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
 * 
 * 예를 들어 “(())()”와 “((()))” 는 VPS 이지만
 * “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다. 
 * 
 * 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 출력하라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stack = new Stack<Character>();
			char[] arr = br.readLine().toCharArray();
			String answer = "YES";

			for (int i = 0; i < arr.length; i++) {
				// '(' 일 경우 스택에 넣는다.
				if (arr[i] == '(') {
					stack.push(arr[i]);
					continue;
				}

				// ')' 일 경우
				// 스택이 비었거나 top이 '('이 아니라면 올바른 괄호 문자열이 아니므로 중지한다.
				if (stack.isEmpty() || stack.peek() != '(') {
					answer = "NO";
					break;
				}

				// 스택의 top이 '('일 경우 pop()
				stack.pop();
			}
			
			// '('이 스택에 남아있다면 올바른 괄호 문자열이 아니다.
			if (!stack.isEmpty())
				answer = "NO";

			System.out.println(answer);
		}

		br.close();
	}
}
