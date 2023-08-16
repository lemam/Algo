import java.util.Scanner;
import java.util.Stack;

/*
 * SWEA 8931번 - 제로 (D3)
 * 
 * 재현이는 영수증을 모아서 동아리의 지출 금액을 세고 있고, 
 * 재민이는 재현이가 부르는 액수를 순서대로 적고 있다.
 * 
 * 재현이는 가끔 잘못된 수를 부르는 실수를 하는데, 
 * 이 때마다 0을 외쳐서, 가장 최근에 재민이가 쓰고 지우지 않았던 수를 지우게 시킨다.
 * 
 * 재현이가 모든 수를 부른 후 재민이가 받아 적은 수의 합은?
 */

public class SWEA_8931_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();	// 테스트 케이스

		for (int tc = 1; tc <= TC; tc++) {
			int K = sc.nextInt(); // 재현이가 액수를 부른 횟수
			Stack<Integer> stack = new Stack<>();
			int answer = 0; // 재민이가 받아 적은 수의 합
			
			// 재현이가 부르는 액수 K번 적기
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt(); // 동아리 지출 금액

				// 0을 부르면 가장 최근에 쓰고 지우지 않았던 수를 지운다.
				if (num == 0) {
					stack.pop();
					continue;
				}

				// 부르는 액수 적기
				stack.push(num);
			}

			// 재민이가 받아 적은 수의 합 구하기
			while (!stack.isEmpty()) {
				answer += stack.pop();
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}

		sc.close();
	}
}
