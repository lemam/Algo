package Baekjoon;/*
 * 백준 1920번 - 수 찾기 (실버 4)
 * 
 * N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 정수의 개수
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 입력
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 이분 탐색을 위해 정렬한다.
		Arrays.sort(nums);

		int M = Integer.parseInt(br.readLine()); // 탐색 횟수
		st = new StringTokenizer(br.readLine());

		// 이분 탐색
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			int answer = binarySearch(nums, n);

			System.out.println(answer);
		}

		br.close();
	}

	// 이분 탐색
	public static int binarySearch(int[] arr, int n) {
		int st = 0;
		int ed = arr.length - 1;
		int mid = (st + ed) / 2;

		while (st <= ed) {
			if (arr[mid] == n)
				return 1;

			if (n > arr[mid]) {
				st = mid + 1;
				mid = (st + ed) / 2;
			} else {
				ed = mid - 1;
				mid = (st + ed) / 2;
			}
		}

		return 0;
	}
}
