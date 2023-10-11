import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 17406번 배열 돌리기 4 (골드 4)
 * 
 * 크기가 N×M 크기인 배열 A가 있을 때, 
 * 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다. 
 * 
 * 배열은 회전 연산을 수행할 수 있다. 
 * 회전 연산은 세 정수 (r, c, s)로 이루어져 있고, 
 * 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을 
 * 시계 방향으로 한 칸씩 돌린다는 의미이다. 
 * 배열의 칸 (r, c)는 r행 c열을 의미한다.
 * 
 * 회전 연산이 두 개 이상이면, 연산을 수행한 순서에 따라 최종 배열이 다르다.
 * 배열 A에 (3, 4, 2), (4, 2, 1) 순서로 연산을 수행하면 배열 A의 값은 12, 
 * (4, 2, 1), (3, 4, 2) 순서로 연산을 수행하면 15 이다.
 * 
 * 배열 A와 사용 가능한 회전 연산이 주어졌을 때, 배열 A의 값의 최솟값을 구해보자. 
 * 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다.
 * 
 * => 배열의 첫 인덱스는 [1][1]이다.
 */

public class BOJ_17406_배열_돌리기_4 {
	private static int N, M;
	private static int[][] A;
	private static int[][] rotateArr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 배열 A의 크기 N, M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수

		A = new int[N + 1][M + 1]; // 배열 A

		// 배열 A 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++)
				A[i][j] = Integer.parseInt(st.nextToken());
		}

		rotateArr = new int[K][3]; // 회전 연산을 저장할 배열 {r, c, s}

		// 회전 연산 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				rotateArr[i][j] = Integer.parseInt(st.nextToken());
		}

		int[] sel = new int[K]; // 순서 저장 배열
		boolean[] visited = new boolean[K]; // 방문 배열

		answer = Integer.MAX_VALUE; // 배열 A의 값의 최솟값

		perm(K, 0, sel, visited);

		System.out.println(answer);

		br.close();
	}

	// 회전 연산 순서 생성
	// n : 원소의 개수, r : 선택한 원소의 개수, sel : 순서 저장 배열, visited : 방문 배열
	private static void perm(int n, int r, int[] sel, boolean[] visited) {
		// 순열 생성 완료
		if (r == n) {
			rotate(sel); // 배열을 순서대로 회전시킨다.
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i])	continue;

			sel[r] = i;
			visited[i] = true;
			perm(n, r + 1, sel, visited);
			visited[i] = false;
		}
	}

	private static void rotate(int[] sel) {
		int[][] copy = copyArr();	// 배열 A의 복사본

		// 순서대로 회전 연산을 실행한다.
		for (int i = 0; i < sel.length; i++) {
			int[] func = rotateArr[sel[i]];
			rotateArr(func[0], func[1], func[2], copy);
		}

		// 배열 copy의 값 구하기
		int value = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int sum = 0;

			for (int j = 1; j <= M; j++)
				sum += copy[i][j];

			value = Math.min(value, sum);
		}

		answer = Math.min(answer, value);
	}

	// 회전 연산
	private static void rotateArr(int r, int c, int s, int[][] arr) {
		for (int n = 1; n <= s; n++) {
			// 위
			int upTmp = arr[r - n][c + n];
			for (int y = c + n; y > c - n; y--) {
				arr[r - n][y] = arr[r - n][y - 1];
			}

			// 오른쪽
			int rightTmp = arr[r + n][c + n];
			for (int x = r + n; x > r - n; x--) {
				arr[x][c + n] = arr[x - 1][c + n];
			}
			arr[r - n + 1][c + n] = upTmp;

			// 아래
			int leftTmp = arr[r + n][c - n];
			for (int y = c - n; y < c + n; y++) {
				arr[r + n][y] = arr[r + n][y + 1];
			}
			arr[r + n][c + n - 1] = rightTmp;

			// 왼쪽
			for (int x = r - n; x < r + n; x++) {
				arr[x][c - n] = arr[x + 1][c - n];
			}
			arr[r + n - 1][c - n] = leftTmp;
		}
	}

	// A 배열 복사본 반환
	private static int[][] copyArr() {
		int[][] result = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				result[i][j] = A[i][j];
			}
		}

		return result;
	}
}
