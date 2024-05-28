package Baekjoon;/*
 * 백준 1436번 - 영화감독 숌 (실버 5)
 * 
 * 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다.
 * 제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
 * 따라서, 숌은 첫 번째 영화의 제목은 "세상의 종말 666", 두 번째 영화의 제목은 "세상의 종말 1666"와 같이 이름을 지을 것이다.
 * 일반화해서 생각하면, N번째 영화의 제목은 세상의 종말 (N번째로 작은 종말의 수) 와 같다.
 * 
 * 숌이 만든 N번째 영화의 제목에 들어간 수를 출력하는 프로그램을 작성하시오. 
 * 숌은 이 시리즈를 항상 차례대로 만들고, 다른 영화는 만들지 않는다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436_영화감독_숌 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 1;
		
		while(cnt != N) {
			num++;
			
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(num);
	}

}
