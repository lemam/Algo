import java.util.Scanner;

public class SWEA_1945_간단한_소인수분해 {
	public static int primeCounter(int N, int primeNum) {
		int count = 0;
		
		while(true) {
			if (N % primeNum != 0) break;
			
			N /= primeNum;
			count++;
		}
		
		return count;
	}

	public static void main(String[] args) {
		/*
		 * N = 2^a * 3^b * 5^c * 7^d * 11^e
		 * 
		 * N이 주어질 때, a, b, c, d, e를 출력
		 * (N은 2 이상 10,000,000 이하이다.)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int a = primeCounter(N, 2);
			int b = primeCounter(N, 3);
			int c = primeCounter(N, 5);
			int d = primeCounter(N, 7);
			int e = primeCounter(N, 11);
			
			System.out.printf("#%d %d %d %d %d %d\n", t, a, b, c, d, e);
		}
		
	}

}
