package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 백준 17471번 - 게리맨더링 (골드 4)
 *  
 * 백준시는 N개의 구역으로 나누어져 있고, 구역은 1번부터 N번까지 번호가 매겨져 있다. 
 * 구역을 두 개의 선거구로 나눠야 하고, 각 구역은 두 선거구 중 하나에 포함되어야 한다. 
 * 선거구는 구역을 적어도 하나 포함해야 하고, 한 선거구에 포함되어 있는 구역은 모두 연결되어 있어야 한다.
 * 
 * 구역 A에서 인접한 구역을 통해서 구역 B로 갈 수 있을 때, 두 구역은 연결되어 있다고 한다.
 * 중간에 통하는 인접한 구역은 0개 이상이어야 하고, 모두 같은 선거구에 포함된 구역이어야 한다.
 * 
 * 공평하게 선거구를 나누기 위해 두 선거구에 포함된 인구의 차이를 최소로 하려고 한다. 
 * 백준시의 정보가 주어졌을 때, 인구 차이의 최솟값을 구해보자.
 * 
 * 구역 A가 구역 B와 인접하면 구역 B도 구역 A와 인접하다.
 * 
 * 백준시를 두 선거구로 나누었을 때, 두 선거구의 인구 차이의 최솟값을 출력한다. 
 * 두 선거구로 나눌 수 없는 경우에는 -1을 출력한다.
 */

public class BOJ_17471_게리맨더링 {
	private static int N;
	private static int[] population;
	private static int[][] adjArr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 구역의 개수

		st = new StringTokenizer(br.readLine());

		population = new int[N + 1]; // 1번 구역부터 N번 구역까지의 인구 수 배열

		// 인구 수 배열 입력
		for (int i = 1; i <= N; i++)
			population[i] = Integer.parseInt(st.nextToken());

		adjArr = new int[N + 1][N + 1]; // 인접 행렬

		// 간선 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int numberOfArea = Integer.parseInt(st.nextToken()); // i구역과 인접한 구역의 수

			for (int j = 0; j < numberOfArea; j++) {
				int v = Integer.parseInt(st.nextToken()); // 인접한 구역 번호
				adjArr[i][v] = adjArr[v][i] = 1; // i 구역과 v 구역은 인접하다.
			}
		}

		boolean[] selected = new boolean[N + 1]; // 구역 선택 여부 저장 배열
		answer = Integer.MAX_VALUE; // 두 선거구의 인구 차이의 최솟값

		devide(0, selected);

		// 두 선거구로 나눌 수 없는 경우에는 -1을 출력한다.
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

		br.close();
	}

	// 1 ~ N까지의 구역을 2개의 선거구로 나누기
	private static void devide(int idx, boolean[] selected) {
		// N까지 탐색을 완료
		if (idx == N) {
			// 구역을 저장할 선거구 리스트
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();

			// 선거구 리스트 저장하기
			for (int i = 1; i <= N; i++) {
				if (selected[i])
					aList.add(i);
				else
					bList.add(i);
			}

			// 모든 구역이 한 선거구에만 들어가 있다면 중단한다.
			if (aList.size() == 0 || bList.size() == 0)
				return;

			// 선거구에 포함된 모든 구역이 서로 연결되어 있는지 확인
			if (check(aList) && check(bList))
				// 인구차 최소값 갱신
				answer = Math.min(answer, getDiff(aList, bList));

			return;
		}

		// 부분 집합 구하기
		selected[idx] = true;
		devide(idx + 1, selected);
		selected[idx] = false;
		devide(idx + 1, selected);
	}

	// 두 선거구의 인구차를 반환한다.
	private static int getDiff(List<Integer> aList, List<Integer> bList) {
		int aSum = 0;
		int bSum = 0;

		for (int i : aList)
			aSum += population[i];

		for (int i : bList)
			bSum += population[i];

		return Math.abs(aSum - bSum);
	}

	// list에 있는 구역이 모두 연결되어 있는지 여부를 반환한다.
	private static boolean check(List<Integer> list) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];
		
		visited[list.get(0)] = true;
		queue.add(list.get(0));

		int cnt = 1; // 방문한 지역의 개수

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 0; i < list.size(); i++) {
				int end = list.get(i);

				// 현재 구역과 end 구역이 인접하고 end 구역을 방문하지 않은 상태이면 큐에 넣는다.
				if (adjArr[curr][end] == 1 && !visited[end]) {
					queue.add(end);
					visited[end] = true;
					cnt++;
				}
			}
		}

		// 방문한 지역의 개수와 list의 크기가 같으면 모두 연결되어 있음을 뜻한다.
		if (cnt == list.size())
			return true;

		return false;
	}
}
