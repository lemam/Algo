import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 10818번 - 최소, 최대 (브론즈3)
 * https://www.acmicpc.net/problem/10818
 * 
 * N개의 정수 중 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 */

public class BOJ_10818_최소_최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (min > num)
				min = num;

			if (max < num)
				max = num;
		}
		
		System.out.println(min + " " + max);
		
		br.close();
	}
}
