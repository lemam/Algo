package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_25314_코딩은_체육과목_입니다 {
	public static void main(String[] args) throws IOException {
//		두 수를 더하는 문제에서
//		만약 입출력이 N바이트 크기의 정수라면 프로그램을 어떻게 구현해야할까?
//		라는 질문을 받았다.
//		
//		long int는 4바이트 정수까지 저장할 수 있는 정수 자료형
//		long long int는 8바이트 정수까지 저장할 수 있는 정수 자료형
//		
//		int 앞에 long을 하나씩 붙일 때마다 4바이트씩 저장 공간이 늘어나는 걸까?
//		라고 생각하며 정수 자료형을 써 내려가기 시작했다.
//		ex) long long long int = 12바이트
//			long long long long int = 16바이트
//		
//		N바이트 정수를 저장할 수 있다고 생각해서 칠판에 쓴 정수 자료형의 이름은?
//		(4 <= N <= 1000; N은 4의 배수)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String answer = "long ".repeat(N / 4) + "int";
		
		System.out.println(answer);
	}
}
