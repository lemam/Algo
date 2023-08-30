import java.util.Scanner;

/*
 * SWEA 1873번 - 상호의 배틀필드 (D3)
 * 
 * 상호는 전차로 시가전을 하는 것을 테마로 한 새로운 게임 “배틀 필드”를 개발하기로 했다.
 * 그래서 먼저 간단하게 프로토 타입 게임을 만들었다.
 * 이 프로토 타입에서 등장하는 전차는 사용자의 전차 하나뿐이며, 적이나 아군으로 만들어진 전차는 등장하지 않는다.
 * 사용자의 전차는 사용자의 입력에 따라 격자판으로 이루어진 게임 맵에서 다양한 동작을 한다.
 * 
 * 다음 표는 게임 맵의 구성 요소를 나타낸다.
	문자	의미
	.	평지(전차가 들어갈 수 있다.)
	*	벽돌로 만들어진 벽
	#	강철로 만들어진 벽
	-	물(전차는 들어갈 수 없다.)
	^	위쪽을 바라보는 전차(아래는 평지이다.)
	v	아래쪽을 바라보는 전차(아래는 평지이다.)
	<	왼쪽을 바라보는 전차(아래는 평지이다.)
	>	오른쪽을 바라보는 전차(아래는 평지이다.)
 * 다음 표는 사용자가 넣을 수 있는 입력의 종류를 나타낸다.
	문자	동작
	U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
	D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
	L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
	R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
	S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 *
 * 전차가 이동을 하려고 할 때, 만약 게임 맵 밖이라면 전차는 당연히 이동하지 않는다.
 * 
 * 전차가 포탄을 발사하면, 
 * 포탄은 벽돌로 만들어진 벽 또는 강철로 만들어진 벽에 충돌하거나 게임 맵 밖으로 나갈 때까지 직진한다.
 * 만약 포탄이 벽에 부딪히면 포탄은 소멸하고, 
 * 부딪힌 벽이 벽돌로 만들어진 벽이라면 이 벽은 파괴되어 칸은 평지가 된다.
 * 강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
 * 게임 맵 밖으로 포탄이 나가면 아무런 일도 일어나지 않는다.
 * 
 * 초기 게임 맵의 상태와 사용자가 넣을 입력이 순서대로 주어질 때, 
 * 모든 입력을 처리하고 나면 게임 맵의 상태가 어떻게 되는지 구하는 프로그램을 작성하라.
 */

public class SWEA_1873_상호의_배틀필드 {
	public static int posX;
	public static int posY;
	public static String[][] map;

	// 12, 3, 6, 9
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int H = sc.nextInt(); // 게임 맵의 높이
			int W = sc.nextInt(); // 게임 맵의 너비

			posX = 0; // 전차 위치 X(행)
			posY = 0; // 전차 위치 Y(열)
			int headDir = 0; // 전차가 바라보는 방향 (위쪽을 시작으로 시계방향)

			map = new String[H][W]; // 게임 맵

			// 1. 맵 입력
			for (int i = 0; i < H; i++) {
				String[] str = sc.next().split("");
				for (int j = 0; j < W; j++) {
					map[i][j] = str[j];

					// 전차 시작 위치, 방향 설정
					if (str[j].equals("^")) {
						headDir = 0;
						posX = i;
						posY = j;
					} else if (str[j].equals(">")) {
						headDir = 1;
						posX = i;
						posY = j;
					} else if (str[j].equals("v")) {
						headDir = 2;
						posX = i;
						posY = j;
					} else if (str[j].equals("<")) {
						headDir = 3;
						posX = i;
						posY = j;
					}
				}
			}

			int N = sc.nextInt(); // 사용자 입력 개수
			String[] commands = sc.next().split("");

			// 2. 사용자 입력 실행
			for (int i = 0; i < N; i++) {
				switch (commands[i]) {
				// 전차를 바라보는 방향을 바꾸고 다음 칸이 평지라면 이동
				case "U":
					headDir = 0;
					move(headDir);
					break;
				case "R":
					headDir = 1;
					move(headDir);
					break;
				case "D":
					headDir = 2;
					move(headDir);
					break;
				case "L":
					headDir = 3;
					move(headDir);
					break;

				// 전차가 현재 바라보고 있는 방향으로 포탄을 발사
				case "S":
					shoot(headDir);
					break;
				default:
					break;
				}
			}

			System.out.print("#" + tc + " ");

			for (String[] arr : map) {
				for (String str : arr) {
					System.out.print(str);
				}
				System.out.println();
			}
		}

		sc.close();
	}

	// 포탄을 발사한다.
	// dir : 전차가 바라보는 방향 (포탄의 발사 방향)
	private static void shoot(int dir) {
		int nx = posX;
		int ny = posY;

		int H = map.length;
		int W = map[0].length;

		while (true) {
			// 포탄의 다음 이동 위치
			nx += dx[dir];
			ny += dy[dir];

			// 바라보는 방향의 한 칸 위가 맵 밖이면 아무런 일도 일어나지 않는다.
			if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
				break;
			}

			// 벽을 만나면 포탄은 소멸한다.
			// 벽돌로 만들어진 벽을 만나면 벽은 파괴되어 평지가 된다.
			if (map[nx][ny].equals("*")) {
				map[nx][ny] = ".";
				break;
			}
			// 강철로 만들어진 벽에 포탄이 부딪히면 아무 일도 일어나지 않는다.
			else if (map[nx][ny].equals("#")) {
				break;
			}
		}
	}

	// 전차를 이동시킨다.
	// dir : 전차가 바라보는 방향
	private static void move(int dir) {
		// 전차가 다음 이동할 위치
		int nx = posX + dx[dir];
		int ny = posY + dy[dir];

		int H = map.length;
		int W = map[0].length;

		// 바라보는 방향의 한 칸 위가 맵 안이고 평지이면 이동한다.
		if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny].equals(".")) {
			// 전차가 있었던 곳은 평지로 표시해준다.
			map[posX][posY] = ".";

			// 전차 이동
			posX = nx;
			posY = ny;
		}

		// 전차 방향 전환
		if (dir == 0)
			map[posX][posY] = "^";
		else if (dir == 1)
			map[posX][posY] = ">";
		else if (dir == 2)
			map[posX][posY] = "v";
		else if (dir == 3)
			map[posX][posY] = "<";
	}
}
