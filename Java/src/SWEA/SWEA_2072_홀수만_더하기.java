package SWEA;

import java.util.Scanner;

public class SWEA_2072_홀수만_더하기 {

	public static void main(String[] args) {
		/*
		10개의 수에서 홀수만 더한 값을 출력 (각 수는 0 이상 10000 이하의 정수)

		input:
		    T = 3
		    test_case = 3 17 1 39 8 41 2 32 99 2 (...)
		output:
		    # 1 200
		    # 2 208
		 */

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int sum = 0;
			
			for (int j = 0; j < 10; j++) {
				int n = sc.nextInt();
				
				if (n % 2 == 0) continue;
				
				sum += n;
			}
			
			System.out.printf("#%d %d\n", i + 1, sum);
		}
		
		sc.close();
	}

}
