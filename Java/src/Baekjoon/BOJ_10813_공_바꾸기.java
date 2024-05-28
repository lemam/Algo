package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 10813번 공 바꾸기 (브론즈 2)
 * https://www.acmicpc.net/problem/10813
 * 
 * 총 N개의 바구니에는 각각 1번부터 N번까지 번호가 매겨져 있다.
 * 바구니에는 공이 1개씩 들어있고, 처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다.
 * 
 * 도현이는 앞으로 M번 공을 바꾸려고 한다. 
 * 도현이는 공을 바꿀 바구니 2개를 선택하고, 두 바구니에 들어있는 공을 서로 교환한다.
 * 
 * 공을 어떻게 바꿀지가 주어졌을 때, M번 공을 바꾼 이후에 각 바구니에 어떤 공이 들어있는지 구하는 프로그램을 작성하시오.
 */

public class BOJ_10813_공_바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 바구니의 개수
		int M = Integer.parseInt(st.nextToken()); // 공을 바꿀 횟수
		int[] baskets = new int[N + 1];

		// 바구니 배열 초기화 (1번 바구니에 1번 공)
		for (int i = 0; i < N + 1; i++) {
			baskets[i] = i;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			// 공 바꾸기
			int temp = baskets[i];
			baskets[i] = baskets[j];
			baskets[j] = temp;
		}

		for (int i = 1; i < N + 1; i++) {
			System.out.print(baskets[i] + " ");
		}

		br.close();
	}

}
