import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 8958번 - OX퀴즈 (브론즈 2)
 * 
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
 * O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다.
 *  
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 */

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			String[] str = br.readLine().split(""); // OX퀴즈 결과 배열
			String prev = ""; // 이전 문제의 결과
			int cnt = 0; // 연속 정답 횟수
			int score = 0; // 총 점수

			for (int i = 0; i < str.length; i++) {
				if (str[i].equals("O")) {
					if (!str[i].equals(prev)) {
						cnt = 1;
					} else {
						cnt++;
					}

					score += cnt;
				}
				prev = str[i];
			}

			System.out.println(score);
		}

		br.close();
	}
}
