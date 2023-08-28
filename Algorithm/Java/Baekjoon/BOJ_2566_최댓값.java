/*
 * 백준 2566번 - 최댓값 (브론즈 3)
 * 
 * <그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 
 * 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 최댓값을 출력하고, 
 * 둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다.
 * 최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2566_최댓값 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 9;
		int max = 0; // 최댓값
		int row = 0; // 최댓값이 위치한 행 번호
		int col = 0; // 최댓값이 위치한 열 번호

		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");

			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(line[j]);

				// 최댓값 체크
				if (max <= num) {
					max = num;
					row = i + 1;
					col = j + 1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row + " " + col);

		br.close();
	}
}
