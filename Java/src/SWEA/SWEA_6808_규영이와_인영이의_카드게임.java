package SWEA;

import java.util.Scanner;

/*
 * SWEA 6808번 - 규영이와 인영이의 카드게임 (D3)
 * 
 * 규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.
 * 한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 
 * 그리고 아홉 라운드에 걸쳐 게임을 진행한다.
 * 
 * 한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.
 * 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,
 * 낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.
 * 
 * 이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.
 * 두 사람의 총점이 같으면 무승부이다.
 * 
 * 이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.
 * 규영이가 내는 카드의 순서를 고정하면, 
 * 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라 규영이의 승패가 정해질 것이다.
 * 이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.
 */

public class SWEA_6808_규영이와_인영이의_카드게임 {
	public static int N = 9;
	public static int[] cards; // 규영이가 받은 9장의 카드에 적힌 수
	public static int[] nums; // 인영이가 받은 9장의 카드에 적힌 수
	public static int[] result; // 인영이가 카드를 내는 순서
	public static boolean[] visited; // 해당 원소 사용 유무
	public static int win, lose; // 규영이가 이기고, 지는 경우의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			cards = new int[N];
			nums = new int[N];
			result = new int[N];
			visited = new boolean[N];
			
			win = 0;
			lose = 0;

			// 배열 입력
			for (int i = 0; i < N; i++) {
				cards[i] = sc.nextInt();
			}

			// 인영이 카드 배열 입력
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				for (int j = 0; j < N; j++) {
					if (cards[j] == i || nums[j] == i)
						break;

					if (j == N - 1)
						nums[idx++] = i;
				}
			}
			
			perm(0);

			System.out.printf("#%d %d %d\n", tc, win, lose);
		}

		sc.close();
	}

	public static void perm(int idx) {
		if (idx == N) {
			// 게임 실행
			playGame();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			result[idx] = nums[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	private static void playGame() {
		int score1 = 0; // 규영이의 점수
		int score2 = 0; // 인영이의 점수

		// 두 사람이 낸 카드에 적힌 수를 비교한다.
		// 높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻는다.
		for (int i = 0; i < N; i++) {
			if (cards[i] > result[i])
				score1 += cards[i] + result[i];
			else
				score2 += cards[i] + result[i];
		}

		// 총점이 더 높은 사람이 승자이다. (총점이 같으면 무승부)
		if (score1 > score2) win++;
		else if (score1 < score2) lose++;
	}
}
