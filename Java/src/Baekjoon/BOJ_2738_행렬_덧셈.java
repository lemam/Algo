package Baekjoon;/*
 * 백준 2738번 - 행렬 덧셈 (브론즈 5)
 * 
 * N*M크기의 두 행렬 A와 B가 주어졌을 때, 
 * 두 행렬을 더하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2738_행렬_덧셈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] size = br.readLine().split(" ");
		int N = Integer.parseInt(size[0]);
		int M = Integer.parseInt(size[1]);

		int[][] A = new int[N][M]; // 행렬 A
		int[][] B = new int[N][M]; // 행렬 B
		int[][] arr = new int[N][M]; // 행렬 A와 B를 더한 행렬

		// 행렬 A 입력
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 행렬 B 입력
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				B[i][j] = Integer.parseInt(line[j]);
			}
		}

		// 두 행렬을 더한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = A[i][j] + B[i][j];
			}
		}
		
		for (int[] a : arr) {
			for (int num : a) {
				System.out.print(num + " ");
			}
			
			System.out.println();
		}
		
		br.close();
	}
}
