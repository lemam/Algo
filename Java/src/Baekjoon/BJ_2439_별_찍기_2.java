import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2439_별_찍기_2 {
	public static void main(String[] args) throws IOException {
//		첫째 줄에 별 1개,
//		둘째 줄에 별 2개,
//		N번째 줄에 별 N개
//		하지만, 오른쪽을 기준으로 정렬한 별을 출력
//		N(1 ≤ N ≤ 100)

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");
			}

			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}

		br.close();
	}
}