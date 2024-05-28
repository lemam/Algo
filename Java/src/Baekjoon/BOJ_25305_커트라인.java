package Baekjoon;/*
 * 백준 25305번 - 커트라인 (브론즈 2)
 * 
 * 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
 * 이들 중 점수가 가장 높은 k명은 상을 받을 것이다.
 * 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
 * 
 * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_25305_커트라인 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 응시자 수
		int k = Integer.parseInt(st.nextToken()); // 상을 받는 사람의 수
		int[] scoreArr = new int[N]; // 학생의 점수 배열

		st = new StringTokenizer(br.readLine());

		// 점수 입력
		for (int i = 0; i < N; i++) {
			scoreArr[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순으로 정렬
		Arrays.sort(scoreArr);

		System.out.println(scoreArr[N - k]);

		br.close();
	}
}
