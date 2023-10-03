import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839_설탕_배달_DP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 배달해야 할 설탕 무게
		int[] dp = new int[N + 1];

		// 초기화 (1개의 봉지를 가져갈 수 있다.)
		if (N >= 3) dp[3] = 1;
		if (N >= 5) dp[5] = 1;
		
		// 6부터 N까지 순회
		for (int i = 6; i <= N; i++) {
			// 5의 배수인 경우
			if (i % 5 == 0)
				dp[i] = dp[i - 5] + 1;
			// 3의 배수인 경우
			else if (i % 3 == 0)
				dp[i] = dp[i - 3] + 1;
			// 둘 다 아닌 경우
			else {
				if(dp[i - 3] != 0 && dp[i - 5] != 0)
					dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
			}
		}
		
		// 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
		if (dp[N] == 0)
			System.out.println(-1);
		else
			System.out.println(dp[N]);

		br.close();
	}
}
