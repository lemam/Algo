import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1717번 - 집합의 표현 (골드 5)
 * 
 * 초기에 n+1개의 집합 {0}, {1}, {2}, ... , {n}이 있다.
 * 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 집합을 표현하는 프로그램을 작성하시오.
 * 
 * m개의 줄에는 각각의 연산이 주어진다.
 * 합집합은 0 a b의 형태로 입력이 주어진다.
 * 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다.
 * 
 * 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다.
 * 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.
 * 
 * 1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 
 * 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.
 */

public class BOJ_1717_집합의_표현 {
	private static StringBuilder sb;
	private static int[] p, rank;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); // 집합의 마지막 번호
		int m = Integer.parseInt(st.nextToken()); // 연산의 개수

		p = new int[n + 1];
		rank = new int[n + 1];

		// make set
		for (int i = 0; i < n + 1; i++)
			p[i] = i;

		// 연산 실행
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken()); // 명령어 (0 : 합집합, 1 : 포함되는지 확인)
			int a = Integer.parseInt(st.nextToken()); // a가 포함되어 있는 집합
			int b = Integer.parseInt(st.nextToken()); // b가 포합되어 있는 집합

			// 합집합
			if (command == 0)
				union(findset(a), findset(b));
			// 두 원소가 같은 집합이 포함되어 있는지를 확인
			else if (command == 1)
				checkSet(a, b);
		}
		
		System.out.println(sb);

		br.close();
	}

	// 두 원소가 같은 집합이 포함되어 있는지를 확인하고 포함되어 있으면 "YES", 그렇지 않다면 "NO"를 출력한다.
	private static void checkSet(int x, int y) {
		if (findset(x) == findset(y))
			sb.append("YES").append("\n");
		else
			sb.append("NO").append("\n");
	}

	private static void union(int x, int y) {
		if (rank[x] > rank[y])
			p[y] = x;
		else {
			p[x] = y;
			
			if (rank[x] == rank[y])
				rank[y]++;
		}
	}

	private static int findset(int x) {
		if (p[x] != x)
			p[x] = findset(p[x]);
		return p[x];
	}
}
