package Baekjoon;/*
 * 백준 2292번 - 벌집 (브론즈 2)
 * 
 * 육각형으로 이루어진 벌집이 있다. 
 * 중앙의 방 1부터 시작해서 이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다.
 * 숫자 N이 주어졌을 때, 벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 
 * 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 계산하는 프로그램을 작성하시오.
 */

import java.util.Scanner;

public class BOJ_2292_벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = 1;	// 현재 겹까지의 최대 번호(벌집 개수)
		int cnt = 1;	// 겹의 개수
		
		// 한 겹 늘어날 때 벌집은 6의 배수로 늘어난다.
		while (num < N) {
			num += 6 * cnt;
			cnt++;
		}
		
		System.out.println(cnt);
		
		sc.close();
	}
}
