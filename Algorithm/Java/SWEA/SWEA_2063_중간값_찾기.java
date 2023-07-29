package solution;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_2063_중간값_찾기 {

	public static void main(String[] args) {
		/*
		중간값: 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치

		input N개의 점수
		output N개의 점수들의 중간값

		(9 ≤ N ≤ 199)

		example
		input: 첫째 줄 N = 9,
		       둘째 줄 scores = 85 72 38 80 69 65 68 96 22
		output = 69
		*/

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] scores = new int[N];
		
		for (int i = 0; i < N; i++) {
			scores[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(scores);
		System.out.println(scores[N / 2]);
	}

}
