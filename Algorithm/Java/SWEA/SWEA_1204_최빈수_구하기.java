package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 1204번 최빈수 구하기 (D2)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh&categoryId=AV13zo1KAAACFAYh&categoryType=CODE&problemTitle=1204&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
 * 최빈수를 이용하여 학생들의 평균 수준을 짐작한다.
 * (최빈수: 특정 자료에서 가장 여러 번 나타나는 값)
 * 
 * 최빈수를 출력하는 프로그램을 작성하여라 
 * (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).
 */

public class SWEA_1204_최빈수_구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int tc = sc.nextInt();
			int[] counter = new int[101]; // 시험 점수 카운트 배열
			int max = 0; // 최빈수
			int maxCnt = 0; // 최빈수의 횟수

			// 학생 1000명의 시험 점수 카운팅
			for (int i = 0; i < 1000; i++) {
				int n = sc.nextInt();
				counter[n]++;
			}

			// 최빈수 구하기
			for (int i = 0; i < counter.length; i++) {
				if (maxCnt <= counter[i]) {
					maxCnt = counter[i];
					max = i;
				}
			}

			System.out.printf("#%d %d\n", tc, max);
		}

		sc.close();
	}
}
