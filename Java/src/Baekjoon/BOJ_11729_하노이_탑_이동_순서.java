package Baekjoon;/*
 * 백준 11729번 - 하노이 탑 이동 순서 (실버 1)
 * 
 * 세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
 * 각 원판은 반경이 큰 순서대로 쌓여있다. 
 * 
 * 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
 * 1. 한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
 * 2. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
 * 
 * 이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 
 * 단, 이동 횟수는 최소가 되어야 한다.
 * 
 * 첫째 줄에 옮긴 횟수 K를 출력한다.
 * 두 번째 줄부터 수행 과정을 출력한다. 
 * 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 
 * 이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11729_하노이_탑_이동_순서 {
	public static StringBuilder sb = new StringBuilder();
	public static int K = 0; // 옮긴 횟수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 원판의 개수

		hanoi(N, 1, 3, 2);
		
		System.out.println(K);
		System.out.println(sb);

		br.close();
	}

	private static void hanoi(int n, int src, int dst, int via) {
		K++;
		
		if (n == 1) {
			sb.append(src + " " + dst).append("\n");
			return;
		}

		hanoi(n - 1, src, via, dst);
		sb.append(src + " " + dst).append("\n");
		hanoi(n - 1, via, dst, src);
	}
}
