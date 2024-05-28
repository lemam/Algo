package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2167번 - 2차원 배열의 합 (실버 5)
 * https://www.acmicpc.net/problem/2167
 * 
 * 2차원 배열이 주어졌을 때 (i, j) 위치부터 (x, y) 위치까지에 저장되어 있는 수들의 합을 구하는 프로그램을 작성하시오.
 * 배열의 (i, j) 위치는 i행 j열을 나타낸다.
 */

public class BOJ_2167_2차원_배열의_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열의 크기 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		// 배열의 값 입력
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 합 구할 부분의 개수
		int K = Integer.parseInt(br.readLine());

		// K번 합 구하기
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			
			// i, j, x, y 입력
			int sum = 0;
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			// [i][j]에서 [x][y]까지의 원소들의 총합
			for (int m = i; m <= x; m++) {
				for (int n = j; n <= y; n++) {
					sum += arr[m][n];
				}
			}

			System.out.println(sum);
		}

		br.close();
	}
}
