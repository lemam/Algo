package Baekjoon;/*
 * 백준 2164번 - 카드2 (실버 4)
 * 
 * N장의 카드가 있다. 
 * 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 
 * 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
 * 
 * 이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다.
 * 우선, 제일 위에 있는 카드를 바닥에 버린다. 
 * 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.
 * 
 * N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
 * 
 * 남게 되는 카드의 번호를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine()); // 카드의 개수
		
		// 큐에 카드 N장 넣기
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 카드가 한 장 남을 때까지 반복
		while(queue.size() > 1) {
			// 1. 제일 위에 있는 카드를 버린다.
			queue.poll();
			
			// 2. 다음 제일 위에 있는 카드를 카드 밑으로 옮긴다.
			queue.add(queue.poll());
		}
		
		// 제일 마지막에 남게 되는 카드의 번호 출력
		System.out.println(queue.poll());

		br.close();
	}
}
