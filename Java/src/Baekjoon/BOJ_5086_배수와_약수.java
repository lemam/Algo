package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 5086번 - 배수와 약수 (브론즈 3)
 * 
 * 4 × 3 = 12이다.
 * 이 식을 통해 다음과 같은 사실을 알 수 있다.
 * 
 * 3은 12의 약수이고, 12는 3의 배수이다.
 * 4도 12의 약수이고, 12는 4의 배수이다.
 * 
 * 두 수가 주어졌을 때, 다음 3가지 중 어떤 관계인지 구하는 프로그램을 작성하시오.
 * 
 * 1. 첫 번째 숫자가 두 번째 숫자의 약수이다.
 * 2. 첫 번째 숫자가 두 번째 숫자의 배수이다.
 * 3. 첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
 * 
 * 입력은 여러 테스트 케이스로 이루어져 있다. 
 * 마지막 줄에는 0이 2개 주어진다. 
 * 두 수가 같은 경우는 없다.
 * 
 * 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를,
 * 배수라면 multiple을,
 * 둘 다 아니라면 neither를 출력한다.
 */

public class BOJ_5086_배수와_약수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String answer = "";
			
			// 0 0 이면 입력 중단
			if (a == 0 && b == 0) break;
			
			if (b % a == 0) answer = "factor";
			else if (a % b == 0) answer = "multiple";
			else answer = "neither";
			
			System.out.println(answer);
		}
		
		br.close();
	}
}
