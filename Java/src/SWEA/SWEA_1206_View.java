package SWEA;

import java.util.Scanner;

/*
 * SW Expert Academy 1206번 View (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh&categoryId=AV134DPqAA8CFAYh&categoryType=CODE&problemTitle=1206&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
 * 빌딩들에 대한 정보가 주어질 때, 조망권이 확보된 세대의 수를 반환하는 프로그램을 작성하시오.
 */

public class SWEA_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dx = { -2, -1, 1, 2 }; // 건물 탐색 방향

		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt(); // 건물의 개수
			int[] heights = new int[N]; // N개의 건물 높이 배열
			int sum = 0; // 조망권이 확보된 세대의 수

			// 건물 높이 입력
			for (int i = 0; i < N; i++) {
				heights[i] = sc.nextInt();
			}

			// 현재 탐색 기준 빌딩과 -2 ~ 2 거리의 빌딩과의 높이의 차 중 최솟값 반환
			for (int i = 2; i < N - 2; i++) {
				int min = heights[i];

				for (int x = 0; x < 4; x++) {
					int diff = heights[i] - heights[i + dx[x]];

					// 높이의 차가 0 이하이면 조망권이 존재하지 않으므로 탐색을 중지한다.
					if (diff <= 0) {
						min = 0;
						break;
					}

					if (min > diff)
						min = diff;
				}

				sum += min;
			}

			System.out.printf("#%d %d\n", t, sum);
		}

		sc.close();
	}
}
