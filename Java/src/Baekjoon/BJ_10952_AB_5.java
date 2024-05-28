package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10952_AB_5 {
	public static void main(String[] args) throws IOException {
//		�� ���� A�� B�� �Է¹��� ����, A+B�� ����ϴ� ���α׷�
//		(0 < A, B < 10)
//		�Է��� ���������� 0 �� ���� ���´�.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (A == 0 && B == 0)
				break;
			
			System.out.println(A + B);
		}

		br.close();
	}
}
