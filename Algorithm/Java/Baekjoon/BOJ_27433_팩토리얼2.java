import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 백준 27433번 - 팩토리얼2 (브론즈 5)
 * 
 * 0보다 크거나 같은 정수 N이 주어진다. 
 * 이때, N!을 출력하는 프로그램을 작성하시오.
 */

public class BOJ_27433_팩토리얼2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
		
		br.close();
	}
	
	// 팩토리얼
	public static long fact(int n) {
		if (n <= 1) return 1;
		
		return n * fact(n-1);
	}
}
