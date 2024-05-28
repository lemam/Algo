package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 백준 28278번 - 스택 2 (실버 4)
 * 
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 다섯 가지이다.
 * 
 * 1. 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2. 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3. 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4. 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5. 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 * 
 * 출력을 요구하는 명령이 주어질 때마다 명령의 결과를 한 줄에 하나씩 출력한다.
 */

public class BOJ_28278_스택_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			int key = Character.getNumericValue(command.charAt(0));

			switch (key) {
			// 1 X : 정수 X를 스택에 넣는다.
			case 1:
				int X = Integer.parseInt(command.split(" ")[1]);
				stack.push(X);
				break;
			// 2 : 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
			case 2:
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.pop() + "\n");
				break;
			// 3 : 스택에 들어있는 정수의 개수를 출력한다.
			case 3:
				sb.append(stack.size() + "\n");
				break;
			// 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
			case 4:
				int result = stack.isEmpty() ? 1 : 0;
				sb.append(result + "\n");
				break;
			// 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
			case 5:
				if (stack.isEmpty())
					sb.append(-1 + "\n");
				else
					sb.append(stack.peek() + "\n");
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb);

		br.close();
	}
}
