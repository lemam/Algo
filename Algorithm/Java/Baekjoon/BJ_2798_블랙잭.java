package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798_블랙잭 {
	
	static int Solution(int[] numbers, int N, int M) {
		int result = 0;
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = numbers[i] + numbers[j] + numbers[k];
					
					// 세 카드의 합이 M과 같을 경우 sum 반환
					if (sum == M) return sum;
					
					// 세 카드의 합이 이전 합보다 크고 M보다 작을 경우 result 갱신
					if (result < sum && sum < M)
						result = sum;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * <블랙잭 규칙>
		 * 카드의 합이 21이 넘지 않으면서 카드의 합을 최대값으로 함
		 * 
		 * <변형 게임 규칙>
		 * 각 카드에 양의 정수가 적혀 있음
		 * 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓음
		 * 딜러는 숫자 M을 크게 외친다.
		 * 
		 * 플레이어는 제한된 시간 안에 N장의 카드 중 3장의 카드를 고름
		 * 고른 카드의 합은 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합 출력
		 * 
		 * N(3 ≤ N ≤ 100), M(10 ≤ M ≤ 300,000)
		 * 카드에 쓰여 있는 수: 100,000을 넘지 않는 양의 정수
		 * 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Solution(numbers, N, M);
		System.out.println(answer);
	}

}
