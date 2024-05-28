package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2422_한윤정이_이탈리아에_가서_아이스크림을_사먹는데 {
	private static int N, answer;
	private static boolean[][] arr;
	private static int[] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 아이스크림 종류의 수
		int M = Integer.parseInt(st.nextToken()); // 섞어먹으면 안되는 조합의 개수
		arr = new boolean[N + 1][N + 1]; // 섞어먹으면 안되는 조합 배열

		// 섞어먹으면 안되는 조합 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = true;
			arr[b][a] = true;
		}

		sel = new int[M];
		answer = 0;

		solution(0, 1);

		System.out.println(answer);

		br.close();
	}

	private static void solution(int count, int index) {
		// 아이스크림을 3개 고른 경우
		if (count == 3) {
			// 섞으면 안되는 조합이 있는지 확인
			for (int i = 0; i < 3; i++) {
				int a = sel[i];
				int b = sel[(i + 1) % 3];

				// 섞으면 안되는 조합이 있는 경우 사용할 수 없는 조합이다.
				if (arr[a][b])
					return;
			}
			
			answer++;
			return;
		}

		// 조합
		for (int i = index; i < N + 1; i++) {
			sel[count] = i;
			solution(count + 1, i + 1);
		}
	}
}
