import java.util.Scanner;

/*
 * SWEA 2806번 - N-Queen (D3)
 * 
 * 8*8 체스보드에 8개의 퀸을 서로 공격하지 못하게 놓는 문제는 잘 알려져 있는 문제이다.
 * 퀸은 같은 행, 열, 또는 대각선 위에 있는 말을 공격할 수 있다. 이 문제의 한가지 정답은 아래 그림과 같다.
 * 
 * 이 문제의 조금 더 일반화된 문제는 Franz Nauck이 1850년에 제기했다.
 * N*N 보드에 N개의 퀸을 서로 다른 두 퀸이 공격하지 못하게 놓는 경우의 수는 몇가지가 있을까?
 * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
 */

public class SWEA_N_Queen {
	public static int N;
	public static int[] board;	// 체스판
	public static int answer;	// 퀸을 놓는 방법의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			board = new int[N];
			answer = 0;

			nqueen(0);
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}

	// nqueen 알고리즘
	public static void nqueen(int row) {
		// 마지막 행까지 수행하면 찾기 완료
		if (row == N) {
			answer++;
			return;
		}

		// row행의 i번째 칸 탐색
		for (int i = 0; i < N; i++) {
			// row행의 i번째 열에 퀸을 놓는다.
			board[row] = i;
			// 퀸을 놓을 수 있는 자리인지 확인한다. (유망성 판단)
			if (promising(row)) {
				// 다음 행 탐색 시작
				nqueen(row + 1);
			}
		}
	}

	// 유망한지 판단하여 반환
	private static boolean promising(int row) {
		// 아래 또는 대각선에 퀸이 있는지 확인
		for (int i = row - 1; i >= 0; i--) {
			if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i]))
				return false;
		}
		
		return true;
	}
}
