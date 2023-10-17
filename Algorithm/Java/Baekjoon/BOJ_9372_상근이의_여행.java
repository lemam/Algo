import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 9372번 - 상근이의 여행 (실버 4)
 * 
 * 상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. 
 * 하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
 * 
 * 이번 방학 동안의 비행 스케줄이 주어졌을 때, 
 * 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
 * 
 * 상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
 */

public class BOJ_9372_상근이의_여행 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가의 수
			int M = Integer.parseInt(st.nextToken()); // 비행기의 종류

			// 비행기 스케줄 입력
			// 모든 국가는 연결되어 있다.
			for (int i = 0; i < M; i++) {
				br.readLine();
			}

			// 최소 신장 트리의 간선의 개수는 (정점의 개수 - 1)이므로
			// 모든 국가를 여행하기 위해 타야하는 비행기 종류의 최소 개수는 (국가의 개수 - 1)이다.
			sb.append(N - 1).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
