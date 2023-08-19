/*
 * 백준 10773번 - 제로 (실버 4)
 * 
 * 재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다.
 * 재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 가장 최근에 재민이가 쓴 수를 지우게 시킨다.
 * 
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 * 재민이가 최종적으로 적어 낸 수의 합을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine()); // 재현이가 부르는 수의 개수
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 0이면 가장 최근에 쓴 수를 지운다.
			if (num == 0)
				stack.pop();
			// 아니면 해당 수를 스택에 저장한다.
			else
				stack.push(num);
		}
		
		// 총합 계산
		int sum = 0;
		
		for (int n : stack)
			sum += n;
		
		System.out.println(sum);

		br.close();
	}
}
