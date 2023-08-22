import java.util.Scanner;

/*
 * SWEA 1966번 - 숫자를 정렬하자
 * 
 * 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.
 */

public class SWEA_1966_숫자를_정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 숫자열의 길이
			int[] arr = new int[N]; // 숫자열

			// 배열 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.print("#" + tc + " ");
			
			for (int n : insertionSort(arr)) {
				System.out.print(n + " ");
			}
			
			System.out.println();
		}

		sc.close();
	}

	// 삽입 정렬한 배열을 반환한다.
	public static int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = 0;

			for (j = i - 1; j >= 0 && key < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			
			arr[j + 1] = key;
		}

		return arr;
	}
}
