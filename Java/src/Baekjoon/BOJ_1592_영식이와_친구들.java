package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1592번 - 영식이와 친구들 (브론즈 2)
 * 
 * 영식이와 친구들이 원형으로 모여서 시계방향으로 1부터 N까지 적혀있는 자리에 앉는다.
 * 영식이와 친구들은 공 던지는 게임을 하기로 했다.
 * 게임의 규칙은 다음과 같다.
 * 
 * 일단 1번 자리에 앉은 사람이 공을 받는다.
 * 그리고 나서 공을 다른 사람에게 던진다.
 * 다시 공을 받은 사람은 다시 공을 던지고, 이를 계속 반복한다.
 * 한 사람이 공을 M번 받았으면 게임은 끝난다. (지금 받은 공도 포함하여 센다.) 
 * 
 * 공을 M번보다 적게 받은 사람이 공을 던질 때,
 * 현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게,
 * 짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
 * 
 * 공을 총 몇 번 던지는지 구하는 프로그램을 작성하시오.
 */

public class BOJ_1592_영식이와_친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 한 사람이 공을 받아야 할 횟수
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int num = 0; // 현재 공을 받는 사람 번호
		int cnt = 0; // 공을 던진 횟수

		while (true) {
			// num번 사람이 공을 받는다.
			arr[num]++;

			// 공을 받은 횟수가 M번이면 게임은 끝난다.
			if (arr[num] >= M) {
				break;
			} else {
				// 공을 받은 횟수가 홀수이면
				if (arr[num] % 2 == 1) {
					// 현재 위치에서 시계 방향으로 L번째 있는 사람에게 공을 던진다.
					num = (num + L) % N;
				}
				// 공을 받은 횟수가 짝수이면
				else {
					// 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다.
					num = (N - L + num) % N;
				}

				cnt++;
			}
		}

		System.out.println(cnt);

		br.close();
	}
}
