import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * SWEA 7102번 - 준홍이의 카드놀이
 * 
 * 준홍이에게는 카드 두 세트가 있다.
 * 각 카드 세트는 1번 카드부터 N번 카드, 1번 카드부터 M번 카드로 구성되어 있다.
 * 
 * 준홍이는 각 카드 세트에서 카드 한 장씩을 골랐다.
 * 그리고 각 카드에 적힌 숫자를 더해보았다.
 * N번 카드와 M번 카드를 골랐다면 카드에 적힌 숫자의 합은 N+M이 될 것이다.
 * 
 * 각 카드 세트에서 카드를 한 장씩 골라서 카드에 적힌 숫자를 합한 결과 중, 등장할 확률이 가장 높은 숫자는 어떤 숫자일지 궁금해졌다.
 * 단, 카드 세트에서 어떤 카드를 선택할 확률은 모두 동일하다고 가정한다.
 * 이를 계산하는 프로그램을 작성하라.
 * 
 * 선택한 두 카드에 적힌 숫자의 합 중 등장할 확률이 가장 높은 것들을 오름차순으로 공백을 사이에 두고 한 줄에 모두 출력한다.
 */

public class SWEA_7102_준홍이의_카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] count = new int[N + M + 1];

			// 선택한 두 카드에 적힌 숫자의 합 빈도수 세기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					count[i + j]++;
				}
			}

			// 가장 많은 빈도수를 가진 합을 큐에 저장
			int max = 0;
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < count.length; i++) {
				// 최대값이 바뀌면 큐에 넣은 값을 모두 지운다.
				if (max < count[i]) {
					max = count[i];
					queue.clear();
				}

				if (max == count[i])
					queue.add(i);
			}

			System.out.print("#" + tc + " ");

			for (int n : queue)
				System.out.print(n + " ");
			
			System.out.println();
		}

		sc.close();
	}
}
