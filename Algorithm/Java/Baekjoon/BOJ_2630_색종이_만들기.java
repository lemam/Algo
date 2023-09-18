import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2630번 - 색종이 만들기 (실버 2)
 * 
 * 여러개의 정사각형칸들로 이루어진 정사각형 모양의 종이가 주어져 있고, 
 * 각 정사각형들은 하얀색으로 칠해져 있거나 파란색으로 칠해져 있다. 
 * 주어진 종이를 일정한 규칙에 따라 잘라서 다양한 크기를 가진 정사각형 모양의 하얀색 또는 파란색 색종이를 만들려고 한다.
 * 
 * 전체 종이의 크기가 N×N(N=2^k, k는 1 이상 7 이하의 자연수) 이라면 종이를 자르는 규칙은 다음과 같다.
 * 
 * 전체 종이가 모두 같은 색으로 칠해져 있지 않으면 
 * 가로와 세로로 중간 부분을 잘라서 똑같은 크기의 네 개의 N/2 × N/2색종이로 나눈다.
 * 
 * 나누어진 종이 I, II, III, IV 각각에 대해서도 앞에서와 마찬가지로 모두 같은 색으로 칠해져 있지 않으면 같은 방법으로 똑같은 크기의 네 개의 색종이로 나눈다.
 * 이와 같은 과정을 잘라진 종이가 모두 하얀색 또는 모두 파란색으로 칠해져 있거나, 
 * 하나의 정사각형 칸이 되어 더 이상 자를 수 없을 때까지 반복한다.
 * 
 * 입력으로 주어진 종이의 한 변의 길이 N과 각 정사각형칸의 색(하얀색 또는 파란색)이 주어질 때 
 * 잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하는 프로그램을 작성하시오.
 * 
 * N은 2, 4, 8, 16, 32, 64, 128 중 하나이다. 
 * 하얀색으로 칠해진 칸은 0, 파란색으로 칠해진 칸은 1로 주어진다.
 * 첫째 줄에는 잘라진 햐얀색 색종이의 개수를 출력하고, 둘째 줄에는 파란색 색종이의 개수를 출력한다.
 */

public class BOJ_2630_색종이_만들기 {
	public static int[][] board; // 주어진 종이
	public static int whiteCnt; // 흰 색종이의 개수
	public static int blueCnt; // 파란 색종이의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 주어진 종이의 한 변의 길이

		board = new int[N][N];
		whiteCnt = 0;
		blueCnt = 0;

		// 정사각형 색 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 분할 정복
		solution(0, 0, N - 1, N - 1);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);

		br.close();
	}

	// 정사각형의 색종이가 모두 같은 색인지 확인한다.
	// 모두 같은 색이라면 그 색을 정수로 반환하고 아니라면 -1을 반환한다.
	private static int getRectColor(int startRow, int startCol, int endRow, int endCol) {
		int color = board[startRow][startCol];

		for (int i = startRow; i <= endRow; i++) {
			for (int j = startCol; j <= endCol; j++) {
				if (board[i][j] != color) {
					return -1;
				}
			}
		}

		return color;
	}

	private static void solution(int startRow, int startCol, int endRow, int endCol) {
		int color = getRectColor(startRow, startCol, endRow, endCol);
		int size = endRow - startRow + 1;

		// 색종이가 하나의 정사각형 칸이 되어 더 이상 자를 수 없는 경우
		if (size == 1) {
			if (color == 0)
				whiteCnt += 1;
			else if (color == 1)
				blueCnt += 1;
			return;
		}

		// 종이 전체가 흰색일 경우
		if (color == 0) {
			whiteCnt += 1;
			return;
		}

		// 종이 전체가 파란색일 경우
		if (color == 1) {
			blueCnt += 1;
			return;
		}

		int half = size / 2;
		
		// 종이가 모두 같은 색으로 칠해져 있지 않은 경우
		solution(startRow, startCol, startRow + half - 1, startCol + half - 1);	// 종이 1
		solution(startRow, startCol + half, startRow + half-1, endCol);			// 종이 2
		solution(startRow + half, startCol, endRow, startCol + half - 1);		// 종이 3
		solution(startRow + half, startCol + half, endRow, endCol);				// 종이 4
	}
}
