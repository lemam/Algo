package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2753_윤년 {
	public static void main(String[] args) throws IOException {
		/*
		 * 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력
		 * 윤년은 
		 * 1. 연도가 4의 배수이면서 100의 배수가 아닐 때
		 * 2. 또는 400의 배수일 때
		 * 
		 * (1 <= 연도 <= 4000)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		
		if (year % 400 == 0)
			System.out.println(1);
		else if ((year % 4 == 0) && (year % 100 != 0))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
