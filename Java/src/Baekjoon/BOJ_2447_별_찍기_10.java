package Baekjoon;

import java.io.*;

/*
 * 백준 2447번 - 별 찍기 - 10 (골드 5)
 * 
 * 재귀적인 패턴으로 별을 찍어 보자. 
 * N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
 * 크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
 * 
 * N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 
 */

public class BOJ_2447_별_찍기_10 {
	public static char[][] star;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		star = new char[N][N]; // 별 배열

		solution(N, 0, 0, false);

		for (char[] arr : star) {
			for (char ch : arr) {
				bw.write(ch);
			}
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}

	// 별 찍기 분할 정복
	// n: 패턴의 크기, row: 시작 행, col: 시작 열, blank: 공백 칸 여부
	private static void solution(int n, int row, int col, boolean blank) {
		// 공백 칸인 경우
		if (blank) {
			for (int i = row; i < row + n; i++) {
				for (int j = col; j < col +n; j++) {
					star[i][j] = ' ';
				}
			}
			return;
		}
		
		// 더 이상 쪼갤 블록이 없을 경우
		if (n == 1) {
			star[row][col] = '*';
			return;
		}
		
		int size = n / 3;	// 분할할 블록의 한 변의 길이
		int count = 0;	// 탐색한 블록의 개수
		
		for (int i = row; i < row + n; i += size) {
			for (int j = col; j < col + n; j+= size) {
				count++;
				// 5번 째 블록은 항상 공백이다.
				if (count == 5)
					solution(size, i, j, true);
				else
					solution(size, i, j, false);
			}
		}
	}
}
