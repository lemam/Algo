package SWEA;

import java.util.Scanner;

/*
 * SW Expert Academy 1208번 Flatten (D3)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq&categoryId=AV5QPsXKA2UDFAUq&categoryType=CODE&problemTitle=2063&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 평탄화: 높은 곳의 상자를 낮은 곳에 옮기는 방식으로 최고점과 최저점의 간격을 줄이는 작업
 * 
 * 평탄화 작업을 위해서 상자를 옮기는 작업 횟수에 제한이 걸려있을 때, 
 * 제한된 횟수만큼 옮기는 작업을 한 후 최고점과 최저점의 차이를 반환하는 프로그램을 작성하시오.
 * 
 * 주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다. 
 * (주어진 data에 따라 0 또는 1이 된다).
 */

public class SWEA_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;	// 테스트 케이스

		for (int t = 1; t <= T; t++) {
			int dump = sc.nextInt(); // 덤프 횟수
			int[] counter = new int[101]; // 배열 높이 개수 배열
			int max = 0; // 최대 높이
			int min = 100; // 최소 높이

			// 배열 입력, 최저/최고점 설정
			for (int i = 1; i < counter.length; i++) {
				int height = sc.nextInt();
				counter[height]++; // height 높이 개수 추가

				// 최대, 최소 높이 갱신
				max = Math.max(max, height);
				min = Math.min(min, height);
			}

			// 평준화
			for (int i = 0; i < dump; i++) {
				// 덤프
				counter[min]--;
				counter[min + 1]++;

				counter[max]--;
				counter[max - 1]++;

				// 더이상 해당 높이의 상자가 없으면 최저/최고점을 다음 층으로 이동한다.
				while (counter[min] == 0) {
					min++;
				}

				while (counter[max] == 0) {
					max--;
				}

				// 평탄화가 완료되면 덤프를 중지한다.
				if (max - min <= 1)
					break;
			}
			
			System.out.printf("#%d %d\n", t, max - min);
		}

		sc.close();
	}
}
