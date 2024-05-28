package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	private static class Tower {
		int index, height;

		public Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 탑의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<Tower>();
		
		// 첫번째 탑을 스택에 넣는다.
		stack.push(new Tower(1, Integer.parseInt(st.nextToken())));
		sb.append("0 ");
		
		for (int i = 2; i <= N; i++) {
			int next = Integer.parseInt(st.nextToken());
			
			while(!stack.isEmpty()) {
				// 왼쪽 탑이 현재 탑보다 높다면 탑의 번호를 출력한다.
				if (stack.peek().height > next) {
					sb.append(stack.peek().index + " ");
					break;
				} 
				
				// 아니라면 pop하고 다음 왼쪽 탑을 확인한다.
				stack.pop();
			}
			
			// 수신하는 탑이 존재하지 않으면 0을 출력한다.
			if (stack.isEmpty())
				sb.append("0 ");
			
			// 현재 탑을 스택에 넣는다.
			stack.push(new Tower(i, next));
		}
		
		System.out.println(sb);

		br.close();
	}
}
