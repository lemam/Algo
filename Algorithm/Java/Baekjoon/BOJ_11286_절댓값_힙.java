/*
 * 백준 11286번 - 절댓값 힙 (실버 1)
 * 
 * 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
 * 1. 배열에 정수 x (x ≠ 0)를 넣는다.
 * 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 
 * 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * 
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 * 
 * 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 
 * 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 
 * 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, 
 * x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 
 * 
 * 입력에서 0이 주어진 회수만큼 답을 출력한다. 
 * 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값_힙 {
	static class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// 절댓값이 작은 순으로
			if (Math.abs(o1) != Math.abs(o2))
				return Math.abs(o1) - Math.abs(o2);
			// 절댓값이 같으면 작은 수부터
			else
				return o1 - o2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MyComparator());

		int N = Integer.parseInt(br.readLine()); // 연산의 개수

		// 연산 실행
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine()); // 연산에 대한 정보를 나타내는 정수

			// x가 0이면 배열에서 절댓값이 가장 작은 값을 출력하고, 배열에서 제거한다.
			// 배열이 비어 있는 경우 0을 출력한다.
			if (x == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
				continue;
			}
			
			// 배열에 x 값을 추가
			pq.add(x);
		}
		
		System.out.println(sb);

		br.close();
	}
}
