package SWEA;/*
 * SWEA 1948번 - 날짜 계산기
 * 
 * 월 일로 이루어진 날짜를 2개 입력 받아,
 * 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하는 프로그램을 작성하라.
 * 
 * 각 달의 마지막 날짜는 다음과 같다.
 * 1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
 * 두 번째 날짜가 첫 번째 날짜보다 항상 크게 주어진다.
 */

import java.util.Scanner;

public class SWEA_1948_날짜_계산기 {
	// 각 달의 마지막 날짜
	public static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int startMonth = sc.nextInt(); // 첫 번째 날짜의 월
			int startDay = sc.nextInt(); // 첫 번째 날짜의 일
			int endMonth = sc.nextInt(); // 두 번째 날짜의 월
			int endDay = sc.nextInt(); // 두 번째 날짜의 일
			int answer = 0;

			for (int i = startMonth; i <= endMonth; i++) {
				if (i == startMonth) {
					answer += days[i] - startDay + 1;
				} else if (i == endMonth) {
					answer += endDay;
				} else {
					answer += days[i];
				}
			}

			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
