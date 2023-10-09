/*
 * 백준 17281번 - ⚾ (골드 4)
 * 
 * ⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다. 
 * 하나의 이닝은 공격과 수비로 이루어져 있고, 총 N이닝 동안 게임을 진행해야 한다.
 * 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.
 * 
 * 두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다. 
 * 9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다. 
 * 타순은 이닝이 변경되어도 순서를 유지해야 한다. 
 * 예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.
 * 
 * 공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다. 
 * 공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다. 
 * 타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다.
 *  
 * 루에 있는 선수를 주자라고 한다. 이닝이 시작될 때는 주자는 없다.
 * 
 * 타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 
 * 각각이 발생했을 때, 벌어지는 일은 다음과 같다.
 * 
 * 안타: 타자와 모든 주자가 한 루씩 진루한다.
 * 2루타: 타자와 모든 주자가 두 루씩 진루한다.
 * 3루타: 타자와 모든 주자가 세 루씩 진루한다.
 * 홈런: 타자와 모든 주자가 홈까지 진루한다.
 * 아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.
 * 
 * 한 야구팀의 감독 아인타는 타순을 정하려고 한다. 
 * 아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다. 
 * 아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 
 * 이제 다른 선수의 타순을 모두 결정해야 한다. 
 * 아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 
 * 
 * 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.
 * 
 * 이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다. 각 결과가 의미하는 정수는 다음과 같다.
 * 안타: 1
 * 2루타: 2
 * 3루타: 3
 * 홈런: 4
 * 아웃: 0
 * 각 이닝에는 아웃을 기록하는 타자가 적어도 한 명 존재한다.
 * 아인타팀이 얻을 수 있는 최대 점수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_baseball {
	private static int N;
	private static int[] players;
	private static int[][] result;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 이닝 수

		result = new int[N + 1][9 + 1]; // 각 이닝에서 얻는 선수들의 결과 배열

		// 결과 배열 입력
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++)
				result[i][j] = Integer.parseInt(st.nextToken());
		}

		players = new int[10]; // 타순
		boolean[] select = new boolean[10]; // 선택한 선수 저장 배열

		// 1번 선수를 4번 타자로 미리 결정했다.
		players[4] = 1;
		select[1] = true;

		answer = 0; // 최대 점수

		setPlayers(9, 1, select);

		System.out.println(answer);

		br.close();
	}

	// 모든 타순 탐색하기
	private static void setPlayers(int n, int r, boolean[] select) {
		// 모든 선수들의 타순을 결정했다면 게임을 진행한다.
		if (r > n) {
			playGame();
			return;
		}

		// 1번 선수는 4번 타자로 미리 결정했다.
		if (r == 4) {
			players[r] = 1;
			setPlayers(n, r + 1, select);
		}
		// 1번 외의 선수들의 타순을 결정한다.
		else {
			for (int i = 2; i <= n; i++) {
				if (select[i]) continue;

				players[r] = i;
				select[i] = true;
				setPlayers(n, r + 1, select);
				select[i] = false; // 원상 복구
			}
		}
	}

	// 게임 진행하기
	private static void playGame() {
		int num = 0; // 타자 번호
		int score = 0; // 점수

		for (int n = 1; n <= N; n++) {
			int[] base = new int[4]; // 타자(홈), 1루, 2루, 3루
			int out = 0; // 아웃 횟수

			// n 이닝 진행
			while (true) {
				num = num % 9 + 1;
				
				int hit = result[n][players[num]];	// num번 선수의 결과

				// 아웃인 경우
				if (hit == 0)
					out++;
				// 아웃이 아닌 경우 이동하기
				else {
					base[0] = 1;
					score += move(hit, base);
				}
				
				// 3아웃이 발생하면 이닝 종료
				if (out >= 3) break;
			}
		}

		// 최댓값 갱신
		answer = Math.max(answer, score);
	}

	// 타자, 주자 이동
	private static int move(int move, int[] base) {
		int result = 0;

		for (int i = 3; i >= 0; i--) {
			if (base[i] == 1) {
				// 이동 거리가 홈 이상이면 점수 추가
				if (i + move > 3)
					result++;
				// 주자 이동
				else
					base[i + move] = 1;

				base[i] = 0;
			}
		}

		return result;
	}
}
