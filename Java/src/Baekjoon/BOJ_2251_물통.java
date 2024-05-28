package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2251_물통 {
	private static class Bucket {
		int a, b, c;

		public Bucket(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	
	private static int[] volumeArr;
	private static boolean[][][] visited;
	private static List<Integer> answerList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		volumeArr = new int[3];

		for (int i = 0; i < 3; i++) {
			volumeArr[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[201][201][201];
		answerList = new ArrayList<Integer>();

		bfs();

		Collections.sort(answerList);

		for (int answer : answerList)
			System.out.print(answer + " ");
		System.out.println();

		br.close();
	}

	private static void bfs() {
		Queue<Bucket> queue = new LinkedList<Bucket>();

		queue.add(new Bucket(0, 0, volumeArr[2])); // 처음에는 세 번째 물통만 차 있다.

		while (!queue.isEmpty()) {
			Bucket now = queue.poll();

			// 이미 방문한 적이 있다면 스킵한다.
			if (visited[now.a][now.b][now.c] == true)
				continue;

			// 방문처리
			visited[now.a][now.b][now.c] = true;

			// 첫 번째 물통이 비어있다면 세 번째 물통의 물의 양을 저장한다.
			if (now.a == 0)
				answerList.add(now.c);

			// 물 옮기기 (from -> to)
			// 1. from 물통이 빌 때까지
			// 2. to 물통이 가득 찰 때까지
			int[] nowWater = { now.a, now.b, now.c }; // now가 가진 물통들의 물의 양

			for (int from = 0; from < 3; from++) {
				for (int to = 0; to < 3; to++) {
					if (from == to)
						continue;

					int[] water = nowWater.clone();

					// from 물통에서 to 물통으로 물을 옮길 때
					// to물통이 가득 차거나 넘치는 경우
					if (water[from] + water[to] >= volumeArr[to]) {
						water[from] -= volumeArr[to] - water[to];
						water[to] = volumeArr[to];
					}
					// from 물통이 빌 경우
					else {
						water[to] += water[from];
						water[from] = 0;
					}

					// 큐에 저장
					queue.add(new Bucket(water[0], water[1], water[2]));
				}
			}
		}
	}
}
