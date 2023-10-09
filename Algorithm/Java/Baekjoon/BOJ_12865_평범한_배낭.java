/*
 * 백준 12865번 - 평범한 배낭 (골드 5)
 * 
 * 이 문제는 아주 평범한 배낭에 관한 문제이다.
 * 한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다. 
 * 세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
 * 
 * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 
 *  각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 
 * 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 
 * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한_배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[] W = new int[N+1];	// 무게
		int[] V = new int[N+1];	// 가치
		int[][] dp = new int[N + 1][K + 1];

		// 물건 정보 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken()); // 무게
			V[i] = Integer.parseInt(st.nextToken()); // 무게
		}
		
		// 모든 물품 탐색
		for (int i = 1; i <= N; i++) {
			// 수용가능무게를 1에서 K까지 탐색
			for (int j = 1; j <= K; j++) {
				// i번째 물품을 담을 수 없는 경우
				if (W[i] > j)
					dp[i][j] = dp[i-1][j];	// 이전 물품의 최대 가치값 저장
				// i번째 물품을 담을 수 있는 경우
				else
					// 이전 물품의 최대 가치값과 
					// i-1번째 물건과 i번째 물건을 같이 넣었을 때의 가치값 중 최대값
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
			}
		}
		
		System.out.println(dp[N][K]);

		br.close();
	}
}
