package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 2587번 - 대표값2 (브론즈 2)
 * 
 * 어떤 수들이 있을 때, 그 수들을 대표하는 값으로 가장 흔하게 쓰이는 것은 평균이다. 
 * 평균은 주어진 모든 수의 합을 수의 개수로 나눈 것이다.
 * 
 * 평균 이외의 또 다른 대표값으로 중앙값이라는 것이 있다. 
 * 중앙값은 주어진 수를 크기 순서대로 늘어 놓았을 때 가장 중앙에 놓인 값이다.
 * 
 * 다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성하시오.
 */

public class BOJ_2587_대표값2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 5;
		int[] arr = new int[N];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 평균 구하기
		int sum = 0;

		for (int n : arr)
			sum += n;

		System.out.println(sum / N);

		// 중앙값 구하기
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);

		br.close();
	}
}
