package Baekjoon;/*
 * 백준 11718번 - 그대로 출력하기 (브론즈 5)
 * 
 * 입력 받은 대로 출력하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class BOJ_11718_그대로_출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}
