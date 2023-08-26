import java.util.Scanner;

/*
 * SWEA 4613번 - 러시아 국기 같은 깃발 (D4)
 * 
 * 당신은 러시아 국기를 만들기로 했다.
 * 먼저 창고에서 오래된 깃발을 꺼내왔다.
 * 
 * 이 깃발은 N행 M열로 나뉘어 있고,
 * 각 칸은 흰색, 파란색, 빨간색 중 하나로 칠해져 있다.
 * 
 * 당신은 몇 개의 칸에 있는 색을 다시 칠해서 이 깃발을 러시아 국기처럼 만들려고 한다. 다음의 조건을 만족해야 한다.
 * 위에서 몇 줄(한 줄 이상)은 모두 흰색으로 칠해져 있어야 한다.
 * 다음 몇 줄(한 줄 이상)은 모두 파란색으로 칠해져 있어야 한다.
 * 나머지 줄(한 줄 이상)은 모두 빨간색으로 칠해져 있어야 한다.
 * 
 * 이렇게 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하여라.
 * 
 * ‘W’는 흰색, ‘B’는 파란색, ‘R’은 빨간색을 의미한다. ‘W’, ‘B’, ‘R’외의 다른 문자는 입력되지 않는다.
 * 러시아 국기 같은 깃발을 만들기 위해서 새로 칠해야 하는 칸의 개수의 최솟값을 구하여 T 줄에 걸쳐서 출력한다.
 */

public class SWEA_4613_러시아_국기_같은_깃발 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 깃발의 행
			int M = sc.nextInt(); // 깃발의 열

			// 각 행의 색상의 개수를 저장하는 배열
			int[] white = new int[N];
			int[] blue = new int[N];
			int[] red = new int[N];

			// 각 행의 색상 개수 세기
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				
				for (int j = 0; j < M; j++) {
					char color = str.charAt(j);
					
					if (color == 'W') white[i]++;
					else if (color == 'B') blue[i]++;
					else red[i]++;
				}
			}
			
			// 모든 경우의 수를 확인하여 최솟값 구하기
			int sum = 0; // 조건을 만족하는 모든 경우에서 (흰색 + 파란색 + 빨간색 칸)의 최대값

			// 파란색 줄의 시작 행 : i ~ N-2행
			for (int i = 1; i <= N - 2; i++) {
				// 파란색 줄의 끝 행 : i ~ N-2행
				for (int j = i; j < N - 1; j++) {
					int wCnt = 0;
					int bCnt = 0;
					int rCnt = 0;

					// 흰색을 칠할 줄에서 나올 흰색 칸의 개수 (0 ~ i-1행까지)
					for (int k = 0; k < i; k++) {
						wCnt += white[k];
					}

					// 파란색을 칠할 줄에서 나올 파란색 칸의 개수 (i ~ i+j행까지)
					for (int k = i; k <= j; k++) {
						bCnt += blue[k];
					}

					// 빨간색을 칠할 줄에서 나올 빨간색 칸의 개수 (i+j+1 ~ N-1행까지)
					for (int k = j + 1; k < N; k++) {
						rCnt += red[k];
					}

					// sum이 클 수록 새로 칠해야 할 칸의 개수가 작음
					sum = Math.max(sum, wCnt + bCnt + rCnt);
				}
			}
			
			// 새로 칠해야 할 칸의 개수
			int answer = N * M - sum;

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
