/*
 * 백준 2751번 - 수 정렬하기 2 (실버 5)
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2751_수_정렬하기_2 {
	public static int heapSize = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] heap = new int[N + 1];

		for (int i = 0; i < N; i++)
			insertMinHeap(heap, Integer.parseInt(br.readLine()));
		
		for (int i = 0; i < N; i++)
			bw.write(deleteMinHeap(heap) + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	// 최소 힙 요소 제거
	private static int deleteMinHeap(int[] heap) {
		int item = heap[1]; // 루트 노드

		// 마지막 노드를 루트 노드에 넣는다.
		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2; // 왼쪽 자식 노드

		// 오른쪽 자식이 있고 오른쪽 자식이 왼쪽 자식보다 작으면
		if (ch + 1 <= heapSize && heap[ch] > heap[ch+1]) {
			ch += 1; // 오른쪽 자식으로 탐색 변경
		}

		// 자식 노드 탐색
		while (ch <= heapSize && heap[p] > heap[ch]) {
			int tmp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = tmp;

			p = ch;
			ch = p * 2;

			// 오른쪽 자식이 있고 오른쪽 자식이 왼쪽 자식보다 작으면
			if (ch + 1 <= heapSize && heap[ch] > heap[ch+1]) {
				ch += 1; // 오른쪽 자식으로 탐색 변경
			}
		}

		return item;
	}

	// 최소 힙 요소 삽입
	private static void insertMinHeap(int[] heap, int item) {
		// 가장 마지막 위치에 item 추가
		heap[++heapSize] = item;

		int ch = heapSize;
		int p = ch / 2;

		// p가 0보다 크고 자식이 부모보다 더 작으면 swap 반복
		while (p > 0 && heap[ch] < heap[p]) {
			int temp = heap[p];
			heap[p] = heap[ch];
			heap[ch] = temp;

			ch = p;
			p = ch / 2;
		}
	}
}
