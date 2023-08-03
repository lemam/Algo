import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� 10818�� - �ּ�, �ִ� (�����3)
 * https://www.acmicpc.net/problem/10818
 * 
 * N���� ���� �� �ּڰ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BOJ_10818_�ּ�_�ִ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (min > num)
				min = num;

			if (max < num)
				max = num;
		}
		
		System.out.println(min + " " + max);
		
		br.close();
	}
}
