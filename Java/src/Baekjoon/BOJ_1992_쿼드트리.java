package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1992번 - 쿼드 트리 (실버 1)
 * 
 * 흑백 영상을 압축하여 표현하는 데이터 구조로 쿼드 트리(Quad Tree)라는 방법이 있다.
 * 흰 점을 나타내는 0과 검은 점을 나타내는 1로만 이루어진 영상(2차원 배열)에서
 * 같은 숫자의 점들이 한 곳에 많이 몰려있으면, 쿼드 트리에서는 이를 압축하여 간단히 표현할 수 있다.
 * 
 * 주어진 영상이 모두 0으로만 되어 있으면 압축 결과는 "0"이 되고, 
 * 모두 1로만 되어 있으면 압축 결과는 "1"이 된다. 
 * 
 * 만약 0과 1이 섞여 있으면 전체를 한 번에 나타내지를 못하고,
 * 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래, 이렇게 4개의 영상으로 나누어 압축하게 되며, 
 * 이 4개의 영역을 압축한 결과를 차례대로 괄호 안에 묶어서 표현한다
 * 
 * 위 그림에서 왼쪽의 영상은 오른쪽의 배열과 같이 숫자로 주어지며, 
 * 이 영상을 쿼드 트리 구조를 이용하여 압축하면 "(0(0011)(0(0111)01)1)"로 표현된다. 
 * N×N 크기의 영상이 주어질 때, 이 영상을 압축한 결과를 출력하는 프로그램을 작성하시오.
 */

public class BOJ_1992_쿼드트리 {
	public static StringBuilder sb;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 영상의 크기

		map = new int[N][N]; // 영상 정보 배열

		// 영상 배열 입력
		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < N; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		sb = new StringBuilder();	

		// 쿼드트리 실행
		solution(0, 0, N, 0);

		// 영상을 압축한 결과 출력
		System.out.println(sb);

		br.close();
	}

	private static void solution(int r, int c, int size, int cnt) {
		int color = getRectColor(r, c, size);	// 압축한 색
		
		// 압축이 가능한 경우 하나의 색상으로 압축한다.
		if (color >= 0) {
			sb.append(color);
			return;
		}
		
		// 각 레벨에서 여는 괄호로 시작
		sb.append('(');

		int half = size / 2;

		solution(r, c, half, 1); // 왼쪽 위
		solution(r, c + half, half, 2); // 오른쪽 위
		solution(r + half, c, half, 3); // 왼쪽 아래
		solution(r + half, c + half, half, 4); // 오른쪽 아래
		
		// 각 레벨이 끝날 때 괄호를 닫아준다.
		sb.append(')');
	}

	// 해당 범위의 사각형의 색을 반환한다. (0 : 흰색, 1 : 검은색)
	// 사각형의 모든 데이터 중 하나라도 다르면 -1을 반환한다.
	// r : 시작 행, c : 시작 열, size : 사각형의 한 변의 길이
	private static int getRectColor(int r, int c, int size) {
		int color = map[r][c]; // 사각형 첫 번째 좌표의 색

		for (int i = r; i <= r + size - 1; i++) {
			for (int j = c; j <= c + size - 1; j++) {
				if (map[i][j] != color)
					return -1;
			}
		}

		return color;
	}
}
