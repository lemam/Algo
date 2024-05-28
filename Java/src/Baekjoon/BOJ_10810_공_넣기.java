import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 10810번 - 공 넣기 (브론즈3)
 * https://www.acmicpc.net/problem/10810
 *
 * 총 N개의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
 * 또, 1번부터 N번까지 번호 적혀있는 공을 매우 많이 가지고 있다.
 * 가장 처음 바구니에는 공이 들어있지 않으며, 바구니에는 공을 1개만 넣을 수 있다.
 *
 * 도현이는 앞으로 M번 공을 넣으려고 한다.
 * 한 번 공을 넣을 때, 공을 넣을 바구니 범위를 정하고,
 * 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣는다.
 * 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고, 새로 공을 넣는다.
 * 공을 넣을 바구니는 연속되어 있어야 한다.
 *
 * 공을 어떻게 넣을지가 주어졌을 때, M번 공을 넣은 이후에
 * 각 바구니에 어떤 공이 들어 있는지 구하는 프로그램을 작성하시오.
 */

public class BOJ_10810_공_넣기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] baskets = new int[N + 1];

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken()); // 시작 바구니 번호
			int j = Integer.parseInt(st.nextToken()); // 끝 바구니 번호
			int k = Integer.parseInt(st.nextToken()); // 공 번호

			for (int l = i; l <= j; l++) {
				baskets[l] = k;
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(baskets[i] + " ");
		}

		br.close();
	}
}