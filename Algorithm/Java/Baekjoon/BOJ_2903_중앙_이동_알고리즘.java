/*
 * 백준 2903번 - 중앙 이동 알고리즘 (브론즈 3)
 * 
 * 외계 지형은 중앙 이동 알고리즘을 이용해서 만들려고 한다.
 * 
 * 알고리즘을 시작하면서 상근이는 정사각형을 이루는 점 4개를 고른다.
 * 그 후에는 다음과 같은 과정을 거쳐서 지형을 만든다.
 * 1. 정사각형의 각 변의 중앙에 점을 하나 추가한다.
 * 2. 정사각형의 중심에 점을 하나 추가한다.
 * 
 * 초기 상태에서 위와 같은 과정을 한 번 거치면 총 4개의 정사각형이 새로 생긴다.
 * 이와 같은 과정을 상근이가 만족할 때 까지 계속한다.
 */

import java.util.Scanner;

public class BOJ_2903_중앙_이동_알고리즘 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// (2^n + 1)^2
		int answer = (int) Math.pow(Math.pow(2, N) + 1, 2);
		System.out.println(answer);

		sc.close();
	}
}
