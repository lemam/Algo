package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_25304_영수증 {
	public static void main(String[] args) throws IOException {
//		 영수증을 보면서 정확하게 계산된 것이 맞는지 확인
//		
//		 1. 구매한 각 물건의 가격과 개수
//		 2. 구매한 물건들의 총 금액
//		 
//		 구매한 물건의 가격과 개수로 계산한 총 금액이
//		 영수증에 적인 총 금액과 일치하는지 검사
//		
//		영수증에 적힌 총 금액 X
//		영수증에 적힌 구매한 물건의 종류의 수 N
//		각 물건의 가격 a, 개수 b
//		
//		일치하면 Yes 출력, 아니면 No 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sum += a * b;
		}
		
		if (X == sum) System.out.println("Yes");
		else System.out.println("No");
	}
}
