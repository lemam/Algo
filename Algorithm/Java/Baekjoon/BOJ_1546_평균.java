/*
 * 백준 1546번 - 평균 (브론즈 1)
 * 
 * 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
 * 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
 * 
 * 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
 * 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546_평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 시험 본 과목의 개수
		double[] grades = new double[N]; // 현재 성적 배열

		double max = 0; // 현재 점수 최고점
		double sum = 0; // 수정한 점수 총합

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 성적 입력, 최고점 찾기
		for (int i = 0; i < N; i++) {
			grades[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, grades[i]);
		}

		// 수정한 점수 총합
		for (int i = 0; i < N; i++) {
			sum += grades[i] / max * 100;
		}
		
		// 수정한 점수들의 평균 출력
		System.out.println(sum / N);

		br.close();
	}
}
