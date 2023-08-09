import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 5597번 - 과제 안 내신 분..? (브론즈5)
 * https://www.acmicpc.net/problem/5597
 * 
 * 교실엔 학생이 30명이 있는데, 
 * 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
 * 
 * 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
 */

public class BOJ_5597_과제_안_내신_분 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] students = new boolean[31];	// 학생 제출 여부 배열
		
		// 제출 학생 추가
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			students[num] = true;
		}
		
		// 제출하지 않은 학생 찾으면 출력
		for (int i = 1, cnt = 0; i < students.length; i++) {
			if (cnt >= 2)
				break;
			
			if (students[i] == false) {
				System.out.println(i);
				cnt++;
			}
		}
		
		br.close();
	}
}
