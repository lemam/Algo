package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 백준 25206번 - 너의 평점은 (실버 5)
 * 
 * 인하대학교 컴퓨터공학과를 졸업하기 위해서는, 전공평점이 3.3 이상이거나 졸업고사를 통과해야 한다.
 * 치훈이의 전공평점을 계산해주는 프로그램을 작성해보자.
 * 전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
 * 
 * P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
 */

public class BOJ_25206_너의_평점은 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 과목 평점을 저장한 Map
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);

		int N = 20;
		double subjectSum = 0; // 전공과목별 (학점 x 과목평점)의 합
		double gradesSum = 0; // 학점의 총합

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String subject = st.nextToken(); // 과목명
			double grades = Double.parseDouble(st.nextToken()); // 학점
			String rating = st.nextToken(); // 등급

			if (rating.equals("P"))	continue;

			subjectSum += grades * map.get(rating);
			gradesSum += grades;
		}

		System.out.println(subjectSum / gradesSum);

		br.close();
	}
}
