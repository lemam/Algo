package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2525_오븐_시계 {
	public static void main(String[] args) throws IOException {
		/*
		 * 인공지능 오븐
		 * 적당한 양의 오리 훈제 재료를 오븐에 넣는다.
		 * 인공지능 오븐은 오븐구이가 끝나는 시간을 분 단위로 자동적으로 계산한다.
		 * 
		 * 오븐 앞면에는 사용자에게 요리가 끝나는 시각을 알려 주는 디지털 시계가 있다.
		 * 
		 * 훈제 오리구이를 시작하는 시각과
		 * 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때,
		 * 오븐 구이가 끝나는 시각을 계산하는 프로그램
		 * 
		 * 현재 시각은 시 A (0 ≤ A ≤ 23)
		 * 분 B (0 ≤ B ≤ 59)
		 * 요리하는 데 필요한 시간 C (0 ≤ C ≤ 1,000)가 분 단위
		 * 
		 * (단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다. 
		 * 디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		int hour = A + (C / 60);
		int min = B + (C % 60);
		
		if (min >= 60) {
			hour += 1;
			min -= 60;
		}
		
		if (hour >= 24)
			hour -= 24;

		System.out.println(hour + " " + min);
	}
}
