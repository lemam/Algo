package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1316번 - 그룹 단어 체커
 * 
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
 * kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 * 
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 */

public class BOJ_1316_그룹_단어_체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0; // 그룹 단어의 개수

		for (int tc = 0; tc < N; tc++) {
			if (checkGroupWord(br.readLine()))
				cnt++;
		}

		System.out.println(cnt);

		br.close();
	}

	public static boolean checkGroupWord(String str) {
		boolean[] check = new boolean[26]; // 문자가 나왔는지 체크하는 배열
		int len = str.length();
		int prev = -1; // 직전 알파벳

		for (int i = 0; i < len; i++) {
			int now = str.charAt(i) - 'a'; // 현재 알파벳

			// 직전 알파벳과 같은 알파벳이면 스킵
			if (prev == now)
				continue;

			// 처음 나온 알파벳일 경우
			if (!check[now]) {
				check[now] = true;
				prev = now;
			}
			// 이전에 나왔던 알파벳일 경우
			else
				return false;
		}

		return true;
	}
}
