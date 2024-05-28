package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2750번 - 수 정렬하기 (브론즈 2)
 * 
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */

public class BOJ_2750_수_정렬하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int n : selectionSort(arr))
			System.out.println(n);
		
		br.close();
	}

	// 선택 정렬
	public static int[] selectionSort(int[] arr) {
		int N = arr.length;

		for (int i = 0; i < N - 1; i++) {
			int min = arr[i];
			int minIdx = i;

			for (int j = i+1; j < N; j++) {
				if (min >= arr[j]) {
					min = arr[j];
					minIdx = j;
				}
			}

			arr[minIdx] = arr[i];
			arr[i] = min;
		}

		return arr;
	}
}
