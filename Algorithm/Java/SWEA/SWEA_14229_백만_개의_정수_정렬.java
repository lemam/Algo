import java.util.Scanner;

/*
 * SWEA 14229번 - 백만 개의 정수 정렬 (D2)
 * 
 * 공백으로 구분된 백만개의 정수가 주어진다.
 * 오름차순으로 정렬한 후 배열 A에 저장하고 A[500000]을 출력하라.
 */

public class SWEA_14229_백만_개의_정수_정렬 {
	public static int[] A;
	public static int[] sortedArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = new int[1000000];
		sortedArr = new int[1000000];

		// 배열 입력
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		mergeSort(0, A.length - 1);
		
		System.out.println(A[500000]);

		sc.close();
	}

	private static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (A[L] <= A[R])
				sortedArr[idx++] = A[L++];
			else
				sortedArr[idx++] = A[R++];
		}
		
		while (L <= mid)
			sortedArr[idx++] = A[L++];
		
		while (R <= right)
			sortedArr[idx++] = A[R++];
		
		for (int i = left; i <= right; i++) {
			A[i] = sortedArr[i];
		}
	}
}
