import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17089_세_친구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

		boolean[][] friendArr = new boolean[N + 1][N + 1]; // 친구 관계 배열
		int[] friendNumArr = new int[N + 1];	// 친구 수 배열

		// 친구관계 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			friendArr[A][B] = true;
			friendArr[B][A] = true;

			friendNumArr[A]++;
			friendNumArr[B]++;
		}

		int answer = Integer.MAX_VALUE;

		for (int a = 0; a <= N; a++) {
			for (int b = a + 1; b <= N; b++) {
				// A와 B가 친구인지 확인한다. 아니라면 건너뛴다.
				if (!friendArr[a][b])
					continue;

				for (int c = b + 1; c <= N; c++) {
					// B와 C가 친구인지 확인한다. 그리고 C와 A가 친구인지 확인한다.
					// 맞다면 A, B, C는 모두 친구이다.
					if (friendArr[b][c] && friendArr[a][c]) {
						// A, B, C의 친구의 수 - 자신을 제외한 선택한 사람(2 * 3 = 6)
						int sum = friendNumArr[a] + friendNumArr[b] + friendNumArr[c] - 6;
						answer = Math.min(sum, answer);
					}
				}
			}
		}

		if (answer == Integer.MAX_VALUE)
			answer = -1;

		System.out.println(answer);

		br.close();
	}
}
