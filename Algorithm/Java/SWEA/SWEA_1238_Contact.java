import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * SWEA 1238번 - Contact (D4)
 * 
 * 비상연락망과 연락을 시작하는 당번에 대한 정보가 주어질 때, 
 * 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 함수를 작성하시오.
 * 
 * 연락 인원은 최대 100명이며, 부여될 수 있는 번호는 1이상, 100이하이다.
 * 중간 중간에 비어있는 번호가 있을 수 있다.
 * 
 * 한 명의 사람이 다수의 사람에게 연락이 가능한 경우 항상 다자 간 통화를 통해 동시에 전달한다. (유향 그래프)
 * 연락이 퍼지는 속도는 항상 일정하다 (전화를 받은 사람이 다음사람에게 전화를 거는 속도는 동일).
 * 비상연락망 정보는 사전에 공유되며 한 번 연락을 받은 사람에게 다시 연락을 하는 일은 없다.
 * 연락을 받을 수 없는 사람도 존재할 수 있다.
 * 
 * 입력받는 데이터는 {from, to, from, to, …} 의 순서로 해석된다.
 * 순서에는 상관이 없다.
 * 동일한 {from, to}쌍이 여러 번 반복되는 경우도 있으며, 한 번 기록된 경우와 여러 번 기록된 경우의 차이는 없다.
 */

public class SWEA_1238_Contact {
	public static int N;
	public static List<Integer>[] adjList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10; // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 입력받는 데이터의 개수
			int V = sc.nextInt(); // 시작점

			adjList = new ArrayList[101]; // 비상 연락망 배열

			for (int i = 0; i < adjList.length; i++) {
				adjList[i] = new ArrayList<>();
			}

			// 비상 연락망 입력
			for (int i = 0; i < N / 2; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();

				if (adjList[st].contains(ed)) continue;

				adjList[st].add(ed);
			}

			System.out.printf("#%d %d\n", tc, bfs(V));
		}

		sc.close();
	}

	public static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		List<Integer> maxList = new ArrayList<>();

		queue.add(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = 0;

			// 레벨 별로 탐색
			for (int i = 0; i < size; i++) {
				int curr = queue.poll();
				
				for (int item : adjList[curr]) {
					if (!visited[item]) {
						queue.add(item);
						visited[item] = true;
						max = Math.max(max, item);
					}
				}
			}
			
			// 레벨 별 최대 값을 저장한다.
			maxList.add(max);
		}

		// 마지막 값은 0이므로 뒤에서 2번 째 값을 반환한다.
		return maxList.get(maxList.size() - 2);
	}
}
