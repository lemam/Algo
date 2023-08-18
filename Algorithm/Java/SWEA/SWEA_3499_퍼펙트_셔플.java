import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * SWEA 3499번 - 퍼펙트 셔플 (D3)
 * 
 * 카드를 퍼펙트 셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것을 의미한다.
 * 
 *  N개의 카드가 있는 덱이 주어질 때 이를 퍼펙트 셔플하면 어떤 순서가 되는지 출력하는 프로그램을 작성하라.
 *  만약 N이 홀수이면, 교대로 놓을 때 먼저 놓는 쪽에 한 장이 더 들어가게 하면 된다.
 */

public class SWEA_3499_퍼펙트_셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] arr = new String[N];

			// 배열 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}

			Queue<String> queue = new LinkedList<>(); // 새로운 카드 덱
			
			// 카드 덱을 절반으로 나눈 카드의 양
			// N이 홀수이면 먼저 놓는 쪽(top)에 한 장 더 들어가게 한다.
			int topLen = (N % 2 == 0) ? (N / 2) : (N / 2 + 1);

			// 교대로 카드 넣기
			for (int i = 0; i < N / 2; i++) {
				queue.add(arr[i]);
				queue.add(arr[i + topLen]);
			}

			// N이 홀수이면 top에 마지막 한 장 넣기
			if (N % 2 == 1)
				queue.add(arr[topLen - 1]);
			
			System.out.print("#" + tc + " ");
			
			while(!queue.isEmpty()) {
				System.out.print(queue.remove() + " ");
			}
			
			System.out.println();
		}

		sc.close();
	}
}
