package SWEA;

import java.util.Scanner;

public class SWEA_1545_거꾸로_출력해_보아요 {
	
	public static void main(String[] args) {
		/*
		 * 주어진 숫자부터 0까지 순서대로 출력
		 * 
		 * ex)
		 * N N-1 N-2 ... 0
		 */
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for (int i = N; i >= 0; i--) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}

}
