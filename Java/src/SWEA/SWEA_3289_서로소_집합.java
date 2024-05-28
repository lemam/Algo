package SWEA;

import java.util.Scanner;

/*
 * SWEA 3289번 - 서로소 집합 (D4)
 * 
 * 초기에 {1}, {2}, ... {n} 이 각각 n개의 집합을 이루고 있다.
 * 
 * 여기에 합집합 연산과, 
 * 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 
 * 연산을 수행하는 프로그램을 작성하시오.
 * 
 * 합집합은 0 a b의 형태로 입력이 주어진다.
 * 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
 * 
 * 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
 * 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * 
 * a와 b는 n 이하의 자연수이며 같을 수도 있다.
 * 
 * 각 테스트 케이스마다 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.
 */

public class SWEA_3289_서로소_집합 {
	public static int[] p; // 집합의 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			
			int n = sc.nextInt(); // 집합의 개수
			int m = sc.nextInt(); // 연산의 개수

			p = new int[n + 1];

			// 집합 배열 초기화
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}

			// 연산 실행
			for (int i = 0; i < m; i++) {
				int com = sc.nextInt(); // 명령어 (0: 합집합, 1: 같은 집합에 포함되어 있는지 확인하는 연산)

				// 두 원소 a, b
				int a = sc.nextInt();
				int b = sc.nextInt();

				// 합집합
				if (com == 0) {
					union(findset(a), findset(b));
				}
				else {
					if (findset(a) == findset(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
			}
			
			System.out.printf("#%d %s\n", tc, sb.toString());
		}

		sc.close();
	}

	public static void union(int x, int y) {
		p[findset(y)] = findset(x);
	}

	public static int findset(int x) {
		if (x != p[x])
			p[x] = findset(p[x]);

		return p[x];
	}
}
