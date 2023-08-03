import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ���� 10807�� - ���� ���� (�����5)
 * https://www.acmicpc.net/problem/10807
 * 
 * �� N���� ������ �־����� ��, ���� v�� �� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BOJ_10807_����_���� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int count = 0;

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == v) {
				count++;
			}
		}

		System.out.println(count);
		
		br.close();
	}
}
