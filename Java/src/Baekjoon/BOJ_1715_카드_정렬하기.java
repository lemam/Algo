package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715_카드_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		int N = Integer.parseInt(br.readLine()); // 숫자 카드 묶음의 개수
		int answer = 0; // 최소 비교 횟수

		// 모든 숫자 카드 묶음의 크기를 오름차순으로 정렬
		for (int i = 0; i < N; i++)
			pq.add(Integer.parseInt(br.readLine()));

		// 가장 작은 두 개의 카드 묶음을 더하고 다시 pq에 넣는 것을 반복
		while (pq.size() > 1) {
			int A = pq.poll();
			int B = pq.poll();
			int sum = A + B;

			answer += sum;
			pq.add(sum);
		}

		System.out.println(answer);

		br.close();
	}
}