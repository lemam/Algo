import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * SWEA 1225번 - 암호생성기 (D3)
 * 
 * 다음 주어진 조건에 따라 n개의 수를 처리하면 8자리의 암호를 생성할 수 있다.
 * 1. 8개의 숫자를 입력 받는다.
 * 2. 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 
 * 다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.
 * 이와 같은 작업을 한 사이클이라 한다.
 * 3. 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
 * 
 * 마지막 암호 배열을 출력하라.
 */

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int t = sc.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();

			// 배열 입력
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			int cnt = 1; // 감소량

			while (true) {
				// 첫 번째 숫자를 cnt만큼 감소시킨다.
				int data = queue.remove() - cnt++;
				
				// 값이 0보다 작아지면 0으로 유지하고 뒤로 보낸 후 중단한다.
				if (data <= 0) {
					data = 0;
					queue.add(data);
					break;
				}
				
				// 맨 뒤로 보낸다.
				queue.add(data);
				
				// cnt가 5이면 한 사이클이 끝났으므로 1로 바꾼다.
				if (cnt > 5)
					cnt = 1;
			}
			
			System.out.print("#" + t + " ");
			
			for (int n : queue)
				System.out.print(n + " ");
			
			System.out.println();
		}

		sc.close();
	}
}
