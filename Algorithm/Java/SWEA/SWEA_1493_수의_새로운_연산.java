import java.util.Scanner;

/*
 * SWEA 1493번 - 수의 새로운 연산 (D3)
 * 
 * 2차원 평면 제 1사분면 위의 격자점 (x,y)에 위 그림과 같이 대각선 순서로 점에 수를 붙인다.
 * 
 * 점 (x,y)에 할당된 수는 #(x,y)로 나타낸다.
 * 반대로 수 p가 할당된 점을 &(p)로 나타낸다.
 * 
 * 두 점에 대해서 덧셈을 정의한다. 
 * 점 (x,y)와 점 (z,w)를 더하면 점 (x+z, y+w)가 된다.
 * 즉, (x,y) + (z,w) = (x+z, y+w)로 정의한다.
 * 
 * 우리가 해야 할 일은 수와 수에 대한 새로운 연산 ★를 구현하는 것으로, 
 * p★q는 #(&(p)+&(q))으로 나타난다.
 * 
 * 각 테스트 케이스마다 p★q의 값을 출력한다.
 */

public class SWEA_1493_수의_새로운_연산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();

			System.out.printf("#%d %d\n", tc, solution(p, q));
		}

		sc.close();
	}

	private static int solution(int p, int q) {
		int[] pp = getPoint(p); // &(p)
		int[] qp = getPoint(q); // &(q)

		// &(p)+&(q)
		int[] point = new int[2];

		point[0] = pp[0] + qp[0];
		point[1] = pp[1] + qp[1];

		return getNum(point);
	}

	// 좌표 point의 수 반환
	private static int getNum(int[] point) {
		int line = point[0] + point[1] - 1; // 대각선의 번호
		int end = line * (line + 1) / 2; // line번 째 대각선의 마지막 수

		// 마지막 좌표에서 point까지 떨어진 x의 거리만큼 end에서 뺀다.
		return end - (line - point[1]);
	}

	// 숫자 n의 좌표를 반환
	private static int[] getPoint(int n) {
		int[] result = new int[2]; // 좌표 [x, y]

		int line = 1; // 대각선의 번호
		int end = 1; // line번 째 대각선의 마지막 수

		// 대각선의 마지막 수는 등차수열로 증가한다.
		while (end < n) {
			end += ++line;
		}

		// end의 좌표 저장
		result[0] = 1;
		result[1] = line;

		// end가 n이 될 때까지 대각선을 따라 올라간다.
		while (end != n) {
			result[0]++;
			result[1]--;
			end--;
		}

		return result;
	}
}
