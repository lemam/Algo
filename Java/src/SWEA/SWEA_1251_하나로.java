package SWEA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * SWEA 1251번 - 하나로
 * 
 * 당신은 인도네시아 내의 N개의 섬들을 연결하는 교통시스템 설계 프로젝트인 ‘하나로’를 진행하게 되었습니다.
 * 본 프로젝트에서는 인도네시아 내의 모든 섬을 해저터널로 연결하는 것을 목표로 합니다.
 * 
 * 해저터널은 반드시 두 섬을 선분으로 연결하며,
 * 두 해저 터널이 교차된다 하더라도 물리적으로는 연결되지 않는 것으로 가정합니다. 
 * B와 A처럼 직접적으로 연결된 경우도 있지만, B와 C처럼 여러 섬에 걸쳐 간접적으로 연결된 경우도 있습니다.
 * 
 * 다만 인도네시아에서는 해저터널 건설로 인해 파괴되는 자연을 위해 다음과 같은 환경 부담금 정책이 있습니다.
 * - 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L^2)만큼 지불
 * 
 * 총 환경 부담금을 최소로 지불하며, N개의 모든 섬을 연결할 수 있는 교통 시스템을 설계하시오.
 * 64비트 integer 및 double로 처리하지 않을 경우, overflow가 발생할 수 있습니다.
 * 
 * 주어진 입력에서 모든 섬들을 잇는 최소 환경 부담금을 소수 첫째 자리에서 반올림하여 정수 형태로 출력하라.
 */

public class SWEA_1251_하나로 {
	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			// 1. 값 입력받기
			int N = sc.nextInt(); // 섬의 개수

			Node[] island = new Node[N + 1]; // 섬 배열

			// 섬의 X좌표 입력 받기
			for (int i = 1; i <= N; i++) {
				int x = sc.nextInt(); // 섬의 X좌표
				island[i] = new Node(x, 0);
			}

			// 섬의 Y좌표 입력 받기
			for (int i = 1; i <= N; i++) {
				int y = sc.nextInt(); // 섬의 Y좌표
				island[i].y = y;
			}

			double E = sc.nextDouble(); // 환경 부담 세율

			// 2. 모든 간선 구하기
			double[][] edges = new double[N * (N - 1) / 2][3]; // 모든 간선의 배열 ([0]: 시작 정점, [1]: 끝 정점, [2]: 가중치)
			int edgeCnt = 0;

			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					edges[edgeCnt][0] = i;
					edges[edgeCnt][1] = j;
					edges[edgeCnt][2] = getDistance(island[i], island[j]);
					edgeCnt++;
				}
			}

			// 3. 간선을 오름차순으로 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}
			});

			// 4. 사이클 발생 없이 N-1개의 간선 뽑기
			p = new int[N + 1]; // 섬 집합 배열

			// make-set
			for (int i = 1; i < N; i++) {
				p[i] = i;
			}

			double answer = 0; // 최소 비용
			int pick = 0; // 뽑은 간선의 개수

			for (int i = 0; i < edges.length; i++) {
				int x = (int) edges[i][0];
				int y = (int) edges[i][1];

				// 사이클이 형성되면 건너 뛴다.
				if (findset(x) == findset(y)) continue;

				// 집합을 합친다.
				union(x, y);

				// 비용 추가
				answer += getCost(edges[i][2], E);

				pick++;

				// 다 뽑았으면 중단한다.
				if (pick == N - 1) break;
			}

			System.out.printf("#%d %d\n", tc, Math.round(answer));
		}
		
		sc.close();
	}

	private static double getCost(double edges, double e) {
		return e * edges;
	}

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	public static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);
		return p[x];
	}

	// 두 섬 사이의 거리를 반환
	public static double getDistance(Node n1, Node n2) {
		return Math.pow(n1.x - n2.x, 2) + Math.pow(n1.y - n2.y, 2);
	}
}
