package SWEA;

import java.util.Scanner;

/*
 * SW Expert Academy 2068번 최대수 구하기 (D1)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQhbqA4QDFAUq&categoryId=AV5QQhbqA4QDFAUq&categoryType=CODE&problemTitle=2068&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
 */

public class SWEA_2068_최대수_구하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int max = 0;

			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();

				if (max < num)
					max = num;
			}

			System.out.printf("#%d %d\n", t, max);
		}

		sc.close();
	}
}
