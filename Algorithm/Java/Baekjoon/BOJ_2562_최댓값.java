import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� 2562�� - �ִ� (�����3)
 * https://www.acmicpc.net/problem/2562
 * 
 * 9���� ���� �ٸ� �ڿ����� �־��� ��, 
 * �̵� �� �ִ��� ã�� �� �ִ��� �� ��° �������� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BOJ_2562_�ִ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int idx = 1;
		
		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (max < num) {
				max = num;
				idx = i;
			}
		}
		
		System.out.println(max);
		System.out.println(idx);
		
		br.close();
	}
}
