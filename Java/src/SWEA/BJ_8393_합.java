package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8393_합 {
	public static void main(String[] args) throws IOException {
		/*
		 * n이 주어졌을 때, 1부터 n까지의 합
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(n * (n + 1) / 2);
	}
}
