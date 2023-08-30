/*
 * 백준 24060번 - 알고리즘 수업 - 병합 정렬 1 (실버 3)
 * 
 * N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 
 * 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
 * 크기가 N인 배열에 대한 병합 정렬 의사 코드는 다음과 같다.
 * 
 * 배열 A에 K 번째 저장 되는 수를 출력한다. 
 * 저장 횟수가 K 보다 작으면 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060_알고리즘_수업_병합_정렬_1 {
	public static int[] temp;
	public static int K;
	public static int count = 0;
	public static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
		K = Integer.parseInt(st.nextToken()); // 저장 횟수

		st = new StringTokenizer(br.readLine());
		int[] A = new int[N]; // 배열 A
		temp = new int[N];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 병합 정렬
		mergeSort(A, 0, A.length - 1);
		
		System.out.println(result);

		br.close();
	}

	// 배열 A를 오름차순 정렬한다.
	private static void mergeSort(int[] A, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2; // p와 r의 중간 지점
			mergeSort(A, low, mid); // 전반부 정렬
			mergeSort(A, mid + 1, high); // 후반부 정렬
			merge(A, low, mid, high); // 병합
		}
	}

	// A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
	// A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
	private static void merge(int[] A, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int t = 0;

		while (i <= mid && j <= high) {
			if (A[i] <= A[j])
				temp[t++] = A[i++];
			else
				temp[t++] = A[j++];
		}

		// 왼쪽 배열 부분이 남은 경우
		while (i <= mid) {
			temp[t++] = A[i++];
		}

		// 오른쪽 배열이 남은 경우
		while (j <= high) {
			temp[t++] = A[j++];
		}

		i = low;
		t = 0;

		while (i <= high) {
			// K번째 저장되는 수를 찾으면 중단한다.
			if (++count == K) {
				result = temp[t];
				return;
			}
			
			A[i++] = temp[t++];
		}
	}
}
