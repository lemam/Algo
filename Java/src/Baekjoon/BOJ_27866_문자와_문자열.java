package Baekjoon;/*
 * 백준 27866번 - 문자와 문자열 (브론즈 5)
 * 
 * 단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_27866_문자와_문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int i = Integer.parseInt(br.readLine());

		System.out.println(S.charAt(i - 1));

		br.close();
	}
}
