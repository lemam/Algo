package SWEA;

import java.util.Scanner;

public class SWEA_2058_자릿수_더하기 {
	
	public static void main(String[] args) {
		/*
		 * 하나의 자연수를 입력 받아 각 자릿수의 합을 출력
		 * (1 ≤ N ≤ 9999)
		 */
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = N;
		int sum = 0;
		
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		
		System.out.println(sum);
		sc.close();
	}

}
