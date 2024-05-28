package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 3003번 - 킹, 퀸, 룩, 비숍, 나이트, 폰 (브론즈 5)
 * https://www.acmicpc.net/problem/3003
 * 
 * 낡은 체스판과 피스를 발견했다.
 * 검정색 피스는 모두 있었으나, 흰색 피스는 개수가 올바르지 않았다.
 * 
 * 체스는 총 16개의 피스를 사용하며, 
 * 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
 * 
 * 발견한 흰색 피스의 개수가 주어졌을 때, 
 * 몇 개를 더하거나 빼야 올바른 세트가 되는지 구하는 프로그램을 작성하시오.
 */

public class BOJ_3003_킹_퀸_룩_비숍_나이트_폰 {
	public static void main(String[] args) throws IOException {
		int[] black = { 1, 1, 2, 2, 2, 8 };
		String answer = "";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		// 흰색 피스가 필요한 개수 계산
		// 피스를 더해야 한다면 양수로, 제거해야 한다면 음수로 출력
		for (int i = 0; i < black.length; i++) {
			answer += black[i] - Integer.parseInt(input[i]) + " ";
		}
		
		System.out.println(answer);

		br.close();
	}
}
