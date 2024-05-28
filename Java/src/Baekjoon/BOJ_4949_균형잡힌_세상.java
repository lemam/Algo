package Baekjoon;/*
 * 백준 4949번 - 균형잡힌 세상 (실버 4)
 * 
 * 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.
 * 
 * 문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.
 * 1. 모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이뤄야 한다.
 * 2. 모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이뤄야 한다.
 * 3. 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
 * 4. 모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
 * 5. 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
 * 
 * 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.
 * 
 * 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
 * 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_균형잡힌_세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();

			// 입력 종료
			if (line.equals("."))
				break;

			System.out.println(solution(line));
		}

		br.close();
	}

	private static String solution(String str) {
		Stack<Character> stack = new Stack<Character>();
		int len = str.length();

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i);

			switch (ch) {
			// 여는 괄호인 경우
			case '(':
			case '[':
				stack.push(ch);
				break;
			// 닫는 소괄호인 경우
			case ')':
				// 스택이 비어있거나 top이 짝이 아니면 균형잡힌 문자열이 아니다.
				if (stack.isEmpty() || stack.peek() != '(')
					return "no";
				else
					stack.pop();
				break;
			// 닫는 대괄호인 경우
			case ']':
				// 스택이 비어있거나 top이 짝이 아니면 균형잡힌 문자열이 아니다.
				if (stack.isEmpty() || stack.peek() != '[')
					return "no";
				else
					stack.pop();
				break;
			// 그 외의 문자는 스킵한다.
			default:
				break;
			}

		}
		
		// 열린 괄호가 남아있다면 균형잡힌 문자열이 아니다.
		if (!stack.isEmpty())
			return "no";

		return "yes";
	}
}
