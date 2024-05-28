package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2588_곱셈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int num = n2;
		
		int n3 = n1 * (num % 10);
		num /= 10;
		
		int n4 = n1 * (num % 10);
		num /= 10;
		
		int n5 = n1 * num;
		
		int n6 = n3 + n4 * 10 + n5 * 100;
		
		System.out.println(n3);
		System.out.println(n4);
		System.out.println(n5);
		System.out.println(n6);
	}

}
