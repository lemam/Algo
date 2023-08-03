import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ���� 10810�� - �� �ֱ� (�����3)
 * https://www.acmicpc.net/problem/10810
 * 
 * �� N���� �ٱ��Ͽ��� 1������ N������ ��ȣ�� �Ű��� �ִ�.
 * ��, 1������ N������ ��ȣ �����ִ� ���� �ſ� ���� ������ �ִ�.
 * ���� ó�� �ٱ��Ͽ��� ���� ������� ������, �ٱ��Ͽ��� ���� 1���� ���� �� �ִ�.
 * 
 * �����̴� ������ M�� ���� �������� �Ѵ�.
 * �� �� ���� ���� ��, ���� ���� �ٱ��� ������ ���ϰ�,
 * ���� �ٱ��Ͽ� ��� ���� ��ȣ�� �����ִ� ���� �ִ´�.
 * �ٱ��Ͽ� ���� �̹� �ִ� ��쿡�� ����ִ� ���� ����, ���� ���� �ִ´�. 
 * ���� ���� �ٱ��ϴ� ���ӵǾ� �־�� �Ѵ�.
 * 
 * ���� ��� �������� �־����� ��, M�� ���� ���� ���Ŀ� 
 * �� �ٱ��Ͽ� � ���� ��� �ִ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BOJ_10810_��_�ֱ� {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] baskets = new int[N + 1];

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken()); // ���� �ٱ��� ��ȣ
			int j = Integer.parseInt(st.nextToken()); // �� �ٱ��� ��ȣ
			int k = Integer.parseInt(st.nextToken()); // �� ��ȣ
			
			for (int l = i; l <= j; l++) {
				baskets[l] = k;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(baskets[i] + " ");
		}
		
		br.close();
	}
}
