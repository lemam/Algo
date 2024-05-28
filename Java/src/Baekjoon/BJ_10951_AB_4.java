package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10951_AB_4 {
	public static void main(String[] args) throws IOException {
//		�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷�
//		(0 < A, B < 10)
		
//		EOF(End of File) ����ϱ�
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input = "";
		
		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(A + B);
		}
		
		br.close();
	}
}
