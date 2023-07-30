package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11022_AB_8 {
	public static void main(String[] args) throws IOException {
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
//		
//		테스트 케이스의 개수 T
//		각 줄에 A와 B가 주어진다. (0 < A, B < 10)
//		
//		각 테스트 케이스마다 "Case #x: A + B = C" 형식으로 출력
//		x는 테스트 케이스 번호이고 1부터 시작
//		C는 A+B
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = A + B;
			
			System.out.printf("Case #%d: %d + %d = %d\n", t, A, B, C);
		}
		
		br.close();
	}
}
