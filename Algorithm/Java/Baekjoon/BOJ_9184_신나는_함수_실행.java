/*
 * 백준 9184번 - 신나는 함수 실행 (실버 2)
 * 
 * 재귀 호출만 생각하면 신이 난다! 아닌가요?
 * 다음과 같은 재귀함수 w(a, b, c)가 있다.
 * 
 * 위의 함수를 구현하는 것은 매우 쉽다. 
 * 하지만, 그대로 구현하면 값을 구하는데 매우 오랜 시간이 걸린다. 
 * (예를 들면, a=15, b=15, c=15)
 * 
 * a, b, c가 주어졌을 때, w(a, b, c)를 출력하는 프로그램을 작성하시오.
 * 
 * 입력은 세 정수 a, b, c로 이루어져 있으며, 한 줄에 하나씩 주어진다. 
 * 입력의 마지막은 -1 -1 -1로 나타내며, 세 정수가 모두 -1인 경우는 입력의 마지막을 제외하면 없다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9184_신나는_함수_실행 {
	public static int[][][] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 함수 w에서 a, b, c 중 20이 넘어가게 되면 w(20, 20, 20)을 호출하고,
		// 0 이하일 경우는 1을 반환하기 때문에
		// 각 배열의 크기를 21 (0~20)로 설정한다.
		memo = new int[21][21][21];

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// -1 -1 -1 이 나오면 입력 종료
			if (a == -1 && b == -1 && c == -1) break;

			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}

		br.close();
	}

	private static int w(int a, int b, int c) {
		// a, b, c 가 0 ~ 20 사이의 수이고, 메모이제이션이 되어 있는 경우
		if ( 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20) {
			if (memo[a][b][c] != 0) {
				return memo[a][b][c]; 
			}
		}
		
		if (a <= 0 || b <= 0 || c <= 0)
			return 1;

		if (a > 20 || b > 20 || c > 20)
			return w(20, 20, 20);

		if (a < b && b < c) {
			memo[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
			return memo[a][b][c];
		}

		memo[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1); 
		return memo[a][b][c];
	}
}
