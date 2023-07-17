package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_1247_부호 {

	public static void main(String[] args) throws IOException {
		/*
		 * N개의 정수들의 합 S의 부호를 구하는 프로그램
		 * 
		 * N(1 ≤ N ≤ 100,000)
		 * 정수의 절댓값은 9223372036854775807보다 작거나 같다.
		 * S=0이면 "0"을, S>0이면 "+"를, S<0이면 "-"를 출력하면 된다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 3; t++) {
			BigInteger S = new BigInteger("0");
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				BigInteger num = new BigInteger(br.readLine());
				S = S.add(num);
			}
			
			if (S.compareTo(BigInteger.ZERO) == 1) {
				System.out.println("+");
			} else if (S.compareTo(BigInteger.ZERO) == 0) {
				System.out.println("0");
			} else {
				System.out.println("-");
			}
		}
	}

}
