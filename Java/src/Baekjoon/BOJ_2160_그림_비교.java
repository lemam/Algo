package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2160번 - 그림 비교 (브론즈 1)
 * 
 * N(2 ≤ N ≤ 50)개의 그림이 있다.
 * 각각의 그림은 5×7의 크기이고, 두 가지 색으로 되어 있다.
 * 이때 두 가지의 색을 각각 ‘X’와 ‘.’으로 표현하기로 하자.
 * 
 * 이러한 그림들이 주어졌을 때, 가장 비슷한 두 개의 그림을 찾아내는 프로그램을 작성하시오.
 * 두 개의 그림에서 다른 칸의 개수가 가장 적을 때, 두 개의 그림이 가장 비슷하다고 하자.
 * 
 * 그림의 번호는 입력되는 순서대로 1, 2, …, N이다.
 * 번호를 출력할 때에는 작은 것을 먼저 출력한다.
 */

public class BOJ_2160_그림_비교 {
	static int R = 5; // 그림 세로길이
	static int C = 7; // 그림 가로길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[][][] map = new char[N][R][C];

		int min = Integer.MAX_VALUE;
		int pic1 = 0;
		int pic2 = 0;

		// 배열 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < R; j++) {
				map[i][j] = br.readLine().toCharArray();
			}
		}

		// 모든 그림 조합 탐색
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int diff = solution(map[i], map[j]);
				if (min > diff) {
					min = diff;
					pic1 = i;
					pic2 = j;
				}
			}
		}

		System.out.println((pic1 + 1) + " " + (pic2 + 1));

		br.close();
	}

	// p1와 p2의 원소를 비교해 서로 같지 않은 칸의 개수를 반환
	public static int solution(char[][] p1, char[][] p2) {
		int cnt = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (p1[i][j] != p2[i][j]) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}