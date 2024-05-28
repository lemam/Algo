package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16937_두_스티커 {
	private static int H, W, N, answer;
	private static int[][] stickers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken()); // 모눈종이의 크기 H x W
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine()); // 스티커의 개수
		stickers = new int[N][3]; // 스티커 배열
		answer = 0;

		// 스티커 크기 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stickers[i][0] = Integer.parseInt(st.nextToken()); // R
			stickers[i][1] = Integer.parseInt(st.nextToken()); // C
			stickers[i][2] = stickers[i][0] * stickers[i][1]; // 넓이
		}

		solution();

		System.out.println(answer);

		br.close();
	}

	private static void solution() {
		// 두 스티커를 선택해 모든 경우의 수 확인하기
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				// 두 스티커를 모눈종이에 붙일 수 있는 경우
				if (canStick(stickers[i], stickers[j])) {
					// 두 스티커의 넓이의 합과 answer를 비교하여 최댓값을 저장한다.
					answer = Math.max(answer, stickers[i][2] + stickers[j][2]);
				}
			}
		}
	}

	private static boolean canStick(int[] sticker1, int[] sticker2) {
		// sticker1을 회전하지 않은/회전한 경우
		for (int i = 0; i < 2; i++) {
			// sticker2을 회전하지 않은/회전한 경우
			for (int j = 0; j < 2; j++) {
				// 두 스티커를 수직으로 붙인 경우
				if (sticker1[i] + sticker2[j] <= H && Math.max(sticker1[(i + 1) % 2], sticker2[(j + 1) % 2]) <= W)
					return true;
				// 두 스티커를 수평으로 붙인 경우
				if (sticker1[i] + sticker2[j] <= W && Math.max(sticker1[(i + 1) % 2], sticker2[(j + 1) % 2]) <= H)
					return true;
			}
		}

		return false;
	}
}
