package solution;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2068_최대수_구하기 {

	public static void main(String[] args) {
		/*
		10개의 수 중 가장 큰 수 출력 (각 수는 0 이상 10000 이하 자연수)

		input:
		    T = 3
		    test_case = 3 17 1 39 8 41 2 32 99 2 (...)
		output:
		    #1 99
		    #2 123
		*/

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int[] list = new int[10];
			
			for (int j = 0; j < 10; j++) {
				list[j] = sc.nextInt();
			}
			
			Arrays.sort(list);
			System.out.printf("#%d %d\n", i + 1, list[9]);
		}
		
		sc.close();
	}

}
