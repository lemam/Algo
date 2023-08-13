/*
 * 백준 10811번 - 바구니 뒤집기 (브론즈 2)
 * 
 * 바구니를 총 N개 
 * 각각의 바구니에는 1번부터 N번까지 번호가 순서대로 적혀져 있다.
 * 바구니는 일렬로 놓여져 있고, 가장 왼쪽 바구니를 1번째 바구니, 가장 오른쪽 바구니를 N번째 바구니라고 부른다.
 * 
 * M번 바구니의 순서를 역순으로 만들려고 한다.
 * 한 번 순서를 역순으로 바꿀 때, 순서를 역순으로 만들 범위를 정하고, 
 * 그 범위에 들어있는 바구니의 순서를 역순으로 만든다.
 * 
 * 바구니의 순서를 어떻게 바꿀지 주어졌을 때, M번 바구니의 순서를 역순으로 만든 다음, 
 * 바구니에 적혀있는 번호를 가장 왼쪽 바구니부터 출력하는 프로그램을 작성하시오.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10811_바구니_뒤집기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 바구니의 개수
		int M = Integer.parseInt(st.nextToken()); // 순서를 바꿀 횟수
		int[] baskets = new int[N + 1]; // 바구니 배열

		// 바구니 번호 입력
		for (int i = 1; i <= N; i++) {
			baskets[i] = i;
		}

		// 역순으로 순서 바꾸기 M번 실행
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			// 역순으로 만들 범위 (i ~ j)
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			int[] temp = new int[j - i + 1]; // 역순 번호 배열

			// 역순 번호 저장
			for (int l = 0; l < temp.length; l++) {
				temp[l] = baskets[j - l];
			}

			// 순서 바꾸기
			for (int l = 0; l < temp.length; l++) {
				baskets[l + i] = temp[l];
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.print(baskets[i] + " ");

		br.close();
	}
}
