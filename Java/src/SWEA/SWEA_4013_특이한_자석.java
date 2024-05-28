package SWEA;/*
 * SWEA 4013번 - 특이한 자석
 * 
 * 엔지니어링 선표는 일을 하던 도중 창고에서 특이한 자석이 놓여있는 판을 발견했다.
 * 이 판에는 4개의 자석이 놓여져 있었고, 각 자석은 8개의 ‘날’(튀어나온 곳)를 가지고 있다.
 * 
 * 자석의 각 날 마다 N 극 또는 S 극의 자성을 가지고 있다.
 * 이 특이한 자석은 [Fig. 1] 과 같이 1 번부터 4 번까지 판에 일렬로 배치되어 있고,
 * 빨간색 화살표 위치에 날 하나가 오도록 배치되어 있다.
 * 
 * 심심한 선표는 이 특이한 자석을 가지고 놀아보니 신기한 규칙을 발견했다.
 * 임의의 자석을 1 칸씩 K 번 회전시키려고 해보니,
 * 하나의 자석이 1 칸 회전될 때, 붙어 있는 자석은 
 * 서로 붙어 있는 날의 자성과 다를 경우에만 인력에 의해 반대 방향으로 1 칸 회전된다.
 * 
 * 이를 신기하게 생각한 선표는 무작위로 자석을 돌렸을 때, 
 * 모든 회전이 끝난 후, 아래와 같은 방법으로 점수를 계산을 하고자 한다.
 * - 1 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 1 점을 획득한다.
 * - 2 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 2 점을 획득한다.
 * - 3 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 4 점을 획득한다.
 * - 4 번 자석에서 빨간색 화살표 위치에 있는 날의 자성이 N 극이면 0 점, S 극이면 8 점을 획득한다.
 * 
 * 4 개 자석의 자성 정보와 자석을 1 칸씩 K 번 회전시키려고 할 때,
 * K 번 자석을 회전시킨 후 획득하는 점수의 총 합을 출력하는 프로그램을 작성하라.
 * 
 * 자석을 회전시키는 방향은 시계방향이 1 로, 반시계 방향이 -1 로 주어진다.
 * 날의 자성은 N 극이 0 으로, S 극이 1 로 주어진다.
 * 각 자석의 날 자성정보는 빨간색 화살표 위치의 날부터 시계방향 순서대로 주어진다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_4013_특이한_자석 {
	public static int[][] magnets; // 1 ~ 4번 자석의 8개 날의 자성 정보 배열
	public static int[] top; // 각 자석의 빨간색 화살표 위치에 있는 날의 자성 인덱스 저장 배열
	public static int[] dir; // 1 ~ 4번 자석의 회전 방향

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt(); // 자석을 회전시키는 횟수
			magnets = new int[4][8];
			top = new int[4];
			dir = new int[4];

			// 자성 정보 입력
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = sc.nextInt();
				}
			}

			// K번 자석을 회전시킨다.
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt() - 1; // 회전시키려는 자석의 번호
				dir[num] = sc.nextInt(); // 회전 방향 (시계방향: 1, 반시계방향: -1, 회전 안 함: 0)

				setLeftDir(num - 1); // num 기준 왼쪽 자석들의 회전 방향 설정
				setRightDir(num + 1); // num 기준 오른쪽 자석들의 회전 방향 설정
				rotate(); // 각 자석들을 회전 방향에 맞게 회전
			}

			// 점수 구하기
			int score = 0;

			for (int i = 0; i < 4; i++) {
				score += magnets[i][0] == 0 ? 0 : Math.pow(2, i);
			}

			System.out.printf("#%d %d\n", tc, score);
		}

		sc.close();
	}

	// 각 자석들을 회전 방향에 맞게 회전시킨다.
	private static void rotate() {
		for (int i = 0; i < 4; i++) {
			// 시계방향 회전
			if (dir[i] == 1)
				rotateClockwise(i);
			// 반시계방향 회전
			else if (dir[i] == -1)
				rotateCounterclockwise(i);
		}
	}

	// 반시계 방향으로 배열을 한 칸 이동시킨다. (왼쪽으로 이동)
	private static void rotateCounterclockwise(int num) {
		int[] temp = Arrays.copyOf(magnets[num], 8);

		for (int i = 0; i < 8; i++) {
			magnets[num][i] = temp[(i + 1 + 8) % 8];
		}
	}

	// 시계 방향으로 배열을 한 칸 이동시킨다. (오른쪽으로 이동)
	private static void rotateClockwise(int num) {
		int[] temp = Arrays.copyOf(magnets[num], 8);

		for (int i = 0; i < 8; i++) {
			magnets[num][i] = temp[(i - 1 + 8) % 8];
		}
	}

	// num번 자석과 바로 왼쪽(num-1)번 자석을 비교하여 회전 방향을 설정한다.
	private static void setRightDir(int num) {
		// 모든 오른쪽 자석을 탐색했으므로 종료한다.
		if (num >= 4)
			return;

		// 왼쪽 자석이 회전하지 않으면 num번 이후 자석도 회전하지 않으므로 종료한다.
		if (dir[num - 1] == 0)
			dir[num] = 0;

		// 왼쪽 자석과 서로 붙어 있는 날의 자성이 같으면 회전하지 않는다.
		else if (magnets[num - 1][2] == magnets[num][6])
			dir[num] = 0;

		// 왼쪽 자석과 서로 붙어 있는 날의 자성이 다르면 반대 방향으로 회전한다.
		else
			dir[num] = dir[num - 1] * -1;

		// 다음 오른쪽 자석의 탐색을 시작한다.
		setRightDir(num + 1);
	}

	// num번 자석과 바로 오른쪽(num+1)번 자석을 비교하여 회전 방향을 설정한다.
	private static void setLeftDir(int num) {
		// 모든 왼쪽 자석을 탐색했으므로 종료한다.
		if (num < 0)
			return;

		// 오른쪽 자석이 회전하지 않으면 num번 이후 자석도 회전하지 않으므로 종료한다.
		if (dir[num + 1] == 0)
			dir[num] = 0;

		// 오른쪽 자석과 서로 붙어 있는 날의 자성이 같으면 회전하지 않는다.
		else if (magnets[num + 1][6] == magnets[num][2])
			dir[num] = 0;

		// 오른쪽 자석과 서로 붙어 있는 날의 자성이 다르면 반대 방향으로 회전한다.
		else
			dir[num] = dir[num + 1] * -1;

		// 다음 왼쪽 자석의 탐색을 시작한다.
		setLeftDir(num - 1);
	}
}
