package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018_체스판_다시_칠하기 {

	// 4방향 탐색 : 12 3 6 9
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	// 다시 칠하는 정사각형의 개수 반환
	public static int solution(String[][] chessboard, String startColor) {
		int CN = chessboard.length;		// 체스판 행 길이
		int CM = chessboard[0].length;	// 체스판 열 길이
		
		String[][] arr = new String[CN][CM];	// 체스판 복사용 배열
		int count = 0;	// 다시 칠한 정사각형 개수

		// chessboard 배열 복사
		for (int i = 0; i < CN; i++) {
			for (int j = 0; j < CM; j++) {
				arr[i][j] = chessboard[i][j];
			}
		}
		
		// 맨 왼쪽 위 칸이 startColor와 다른 색이면 다시 칠한다.
		if (!arr[0][0].equals(startColor)) {
			arr[0][0] = startColor;
			count++;
		}
		
		// 체스판 탐색
		for (int k = 0; k < CN; k++) {
			for (int l = 0; l < CM; l++) {
				// 4방향 탐색
				for (int x = 0; x < 4; x++) {
					int row = k + dx[x];
					int col = l + dy[x];
					
					if (row < 0 || row >= CN) continue;
					if (col < 0 || col >= CM) continue;
					
					// 탐색한 칸이 현재 칸과 같은 색이면 탐색한 칸의 색을 다시 칠한다.
					if (arr[row][col].equals(arr[k][l])) {
						arr[row][col] = arr[k][l].equals("B") ? "W" : "B";
						count++;
					}
				}
			}
		}
		
		return count;
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] board = new String[N][M];	// N * M 크기의 보드 배열
		int min = Integer.MAX_VALUE;			// 다시 칠해야 하는 정사각형의 최소 개수

		// 보드 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken().split("");
		}

		// 완전 탐색 - 탐색 시작 인덱스 선택
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				String[][] chessboard = new String[8][8];	// 8 x 8 체스판 배열
                int count = 0;	// 다시 칠한 정사각형 개수
				
				// 체스판 배열 할당
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						int curRow = k + i;
						int curCol = l + j;
						
						chessboard[k][l] = board[curRow][curCol];
					}
				}
				
				// 체스판 탐색
				// 1. 맨 왼쪽 위 칸이 흰색인 경우
				count = solution(chessboard, "W");
				
				if (min > count) min = count;
				
				// 2. 맨 왼쪽 위 칸이 검은색인 경우
				count = solution(chessboard, "B");
				
				if (min > count) min = count;
			}
		}
		
		System.out.println(min);
 	}

}
