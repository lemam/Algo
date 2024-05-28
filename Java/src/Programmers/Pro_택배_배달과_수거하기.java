package Programmers;

public class Pro_택배_배달과_수거하기 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int deliCap = 0; // 배달할 수 있는 상자의 개수
		int pickupCap = 0; // 수거할 수 있는 상자의 개수

		// 거리가 가장 먼 집부터 확인한다.
		for (int i = n - 1; i >= 0; i--) {
			// i번째 집에서 배달, 수거해야 할 상자 개수 추가
			deliCap -= deliveries[i];
			pickupCap -= pickups[i];

			int cnt = 0; // 방문 횟수

			// 트럭에 배달해야 할 상자가 부족하거나 수거해야할 공간이 없으면
			// 물류 창고과 목적지를 왕복한다.
			while (deliCap < 0 || pickupCap < 0) {
				deliCap += cap;
				pickupCap += cap;
				cnt++;
			}

			// 이동 거리 추가
			answer += (i + 1) * 2 * cnt;
		}

		return answer;
	}
}
