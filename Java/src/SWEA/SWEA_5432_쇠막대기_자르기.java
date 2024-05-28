package SWEA;

import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 5432번 - 쇠막대기 자르기 (D4)
 * 
 * 여러 개의 쇠막대기를 레이저로 절단하려고 한다.
 * 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서 수직으로 발사하여 쇠막대기들을 자른다.
 * 
 * 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
 * 1. 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
 * 2. 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓는다.
 * 3. 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
 * 4. 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
 * 
 * 이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
 * 1. 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 “()” 으로 표현된다. 또한, 모든 “()”는 반드시 레이저를 표현한다.
 * 2. 쇠막대기의 왼쪽 끝은 여는 괄호 ‘(’ 로, 오른쪽 끝은 닫힌 괄호 ‘)’ 로 표현된다.
 * 
 * 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하라.
 */

public class SWEA_5432_쇠막대기_자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int len = str.length();
			
			Stack<Character> stack = new Stack<>();
			int irons = 0; // 현재 포개져 있는 쇠 막대기 수
			int answer = 0; // 쇠막대기 조각의 총 개수

			stack.push(str.charAt(0));

			for (int i = 1; i < len; i++) {
				char ch = str.charAt(i);
				
				// 이전 괄호와 현재 괄호를 비교한다.
				// (( 이면 쇠막대기 수를 하나 증가시킨다.
				if (ch == '(' && ch == stack.peek()) {
					irons++;
				}
				// () 이면 레이저를 뜻하므로 왼쪽에 절단된 쇠막대기 개수(irons의 개수)를 더한다.
				else if (ch == ')' && ch != stack.peek()) {
					answer += irons;
				}
				// )) 이면 쇠막대기의 수를 하나 감소시키고 끝에 남은 절단된 조각을 더해준다.
				else if (ch == ')' && ch == stack.peek()) {
					irons--;
					answer += 1;
				}

				stack.push(ch);
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
