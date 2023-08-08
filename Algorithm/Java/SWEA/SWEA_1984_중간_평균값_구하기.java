package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 1984번 중간 평균값 구하기 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq&categoryId=AV5Pw_-KAdcDFAUq&categoryType=CODE&problemTitle=1984&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
 * (소수점 첫째 자리에서 반올림한 정수를 출력한다.)
 */

public class SWEA_1984_중간_평균값_구하기 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int[] nums = new int[10];
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			// 10개의 수 배열에 저장
			for (int i = 0; i < 10; i++) {
				nums[i] = sc.nextInt();

				// 최솟값 저장
				if (min > nums[i])
					min = nums[i];

				// 최댓값 저장
				if (max < nums[i])
					max = nums[i];
			}

			double sum = 0;

			// 최솟값과 최댓값을 제외한 모든 수의 합
			for (int i = 0; i < 10; i++) {
				if (nums[i] == min || nums[i] == max)
					continue;

				sum += nums[i];
			}

			System.out.printf("#%d %d\n", t, Math.round(sum / 8));
		}

		sc.close();
	}
}
