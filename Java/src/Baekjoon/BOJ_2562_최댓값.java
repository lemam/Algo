import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2562번 - 최댓값 (브론즈3)
 * https://www.acmicpc.net/problem/2562
 *
 * 9개의 서로 다른 자연수가 주어질 때,
 * 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.
 */

public class BOJ_2562_최댓값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int idx = 1;

		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());

			if (max < num) {
				max = num;
				idx = i;
			}
		}

		System.out.println(max);
		System.out.println(idx);

		br.close();
	}
}