package Solution;

import java.util.Scanner;

/*
 * SW Expert Academy 2063번 중간값 찾기 (D1)
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq&categoryId=AV5QPsXKA2UDFAUq&categoryType=CODE&problemTitle=2063&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 * 
 * 중간값: 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치
 * 
 * 입력으로 N 개의 점수가 주어졌을 때, 중간값을 출력하라.
 */

public class SWEA_2063_중간값_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		arr = selectionSort(arr);
		
		System.out.println(arr[N / 2]);

		sc.close();
	}

	// 선택 정렬
	public static int[] selectionSort(int[] arr) {
		// 가장 작은 값의 원소부터 차례대로 선택하여 위치를 교환
		int N = arr.length;

		for (int i = 0; i < N - 1; i++) {
			int minIdx = i; // 가장 작은 원소의 인덱스

			// 범위 내의 가장 작은 원소 값 찾기
			for (int j = i + 1; j < N; j++) {
				if (arr[minIdx] > arr[j])
					minIdx = j;
			}

			// i와 minIdx 인덱스 요소끼리 서로 교환
			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}

		return arr;
	}
}
