import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2884_알람_시계 {
	public static void main(String[] args) throws IOException {
		/*
		 * 45분 일찍 알람 설정하기
		 * 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸기
		 * 
		 * 상근이가 설정한 알람 시간 H시 M분
		 * (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
		 * 
		 * 입력 시간은 24시간 표현을 사용
		 * 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다.
		 * 불필요한 0은 사용하지 않는다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		int hour = 0;	// 설정할 알람 시간
		int minute = 0;	// 설정할 알람 분
		
		if (M - 45 < 0) {
			minute = 60 + (M - 45);
			if (H == 0) hour = 23;
			else hour = H - 1;
		} else {
			minute = M - 45;
			hour = H;
		}
		
		System.out.println(hour + " " + minute);
	}
}
