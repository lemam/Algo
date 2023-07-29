import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		/*
		 * 스도쿠: 9 x 9 칸으로 이루어진 표에 1부터 9까지의 숫자를 채워넣는 퍼즐
		 * 
		 * <규칙>
		 * 가로 줄, 세로 줄, 3x3 크기의 작은 격자 각각에 1에서 9까지의 숫자를 한 번씩 넣음
		 * 1 ~ 9까지의 숫자가 겹치지 않아야 함
		 * 
		 * 겹치는 숫자가 없을 경우(정답일 경우), 1 출력
		 * 아니면 0 출력
		 * 
		 * 퍼즐은 모두 숫자로 채워진 상태로 주어진다
		 * 입력으로 주어지는 퍼즐의 모든 숫자는 1 이상 9 이하의 정수이다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			boolean answer = true;
			
			// 스도쿠 입력 받기
			int[][] sudoku = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			// 가로 줄 확인
			for (int i = 0; i < 9; i++) {
				if (!answer) break;
				
				boolean[] flagList = new boolean[10];
				
				for (int j = 0; j < 9; j++) {
					int num = sudoku[i][j];
					
					// 이미 존재하는 숫자라면 오답 출력
					if (flagList[num] == true) {
						answer = false;
						break;
					} 
					// 처음 입력된 수라면 flagList 갱신
					else {
						flagList[num] = true;
					}
				}
			}
			
			// 세로 줄 확인
			for (int i = 0; i < 9; i++) {
				if (!answer) break;
				
				boolean[] flagList = new boolean[10];
				
				for (int j = 0; j < 9; j++) {
					int num = sudoku[j][i];
					
					// 이미 존재하는 숫자라면 오답 출력
					if (flagList[num] == true) {
						answer = false;
						break;
					} 
					// 처음 입력된 수라면 flagList 갱신
					else {
						flagList[num] = true;
					}
				}
			}
			
			// 3 x 3 격자 확인
			for (int i = 0; i < 6; i += 3) {
				for (int j = 0 ; j < 6; j += 3) {
					if (!answer) break;
					
					boolean[] flagList = new boolean[10];
					int row = i + 3;
					int col = j + 3;
					
					for (int k = i; k < row; k++) {
						if (!answer) break;
						
						for (int l = j; l < col; l++) {
							int num = sudoku[k][l];
							
							// 이미 존재하는 숫자라면 오답 출력
							if (flagList[num] == true) {
								answer = false;
								break;
							} 
							// 처음 입력된 수라면 flagList 갱신
							else {
								flagList[num] = true;
							}
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n", t, answer ? 1 : 0);
		}
		
		sc.close();
	}
}
