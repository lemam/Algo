package Baekjoon;/*
 * 백준 2563번 - 색종이 (실버 5)
 * 
 * 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다.
 * 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 
 * 색종이의 변과 도화지의 변이 평행하도록 붙인다.
 * 
 * 이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 
 * 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int whiteSize = 100; // 흰색 도화지의 한 변의 길이
		int blackSize = 10; // 검은색 색종이의 한 변의 길이
		int[][] board = new int[whiteSize][whiteSize];	// 흰색 도화지 배열

		int N = Integer.parseInt(br.readLine()); // 색종이의 수

		// 색종이 영역 추가
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());	// 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리 (x좌표)
			int bottom = Integer.parseInt(st.nextToken());	// 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리 (y좌표)

			// 색종이 영역은 1로 저장한다.
			for (int y = bottom; y < bottom + blackSize; y++) {
				for (int x = left; x < left + blackSize; x++) {
					board[y][x] = 1;
				}
			}
		}
		
		int answer = 0;
		
		// 색종이 영역의 개수를 센다.
		for (int i = 0; i < whiteSize; i++) {
			for (int j = 0; j <whiteSize; j++) {
				if (board[i][j] == 1) answer++;
			}
		}
		
		System.out.println(answer);

		br.close();
	}
}
