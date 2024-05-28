package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2480_주사위_세개 {
	public static void main(String[] args) throws IOException {
		/*
		 * 1에서부터 6까지의 눈을 가진 3개의 주사위를 던짐 규칙에 따라 상금을 받는다.
		 * 
		 * <규칙> 
		 * 1. 같은 눈이 3개가 나오면 10000원 + (같은 눈) x 1000원 
		 * 2. 같은 눈이 2개만 나오면 1000원 + (같은 눈) x 100원 
		 * 3. 모두 다른 눈이 나오면 (그 중 가장 큰 눈) x 100원
		 * 
		 * 3개의 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램
		 */
		
		/*
		 1. x == y, x == z, y == z
		 
		 2. x == y, x != z, y != z
		 	x != y, x == z, y != z
		 	x != y, x != y, y == z
		 
		 3. x != y, x != z, y != z
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(tk.nextToken());
		int y = Integer.parseInt(tk.nextToken());
		int z = Integer.parseInt(tk.nextToken());


		if (x == y && x == z && y == z) {
			System.out.println(10000 + x * 1000);
		} else if ((x == y && x != z && y != z) || (x != y && x == z && y != z)) {
			System.out.println(1000 + x * 100);
		} else if ((x != y && x != y && y == z) || (x != y && x != y && y == z)) {
			System.out.println(1000 + y * 100);
		} else {
			int maxNum = Math.max(Math.max(x, y), z);
			System.out.println(maxNum * 100);
		}
	}
}
