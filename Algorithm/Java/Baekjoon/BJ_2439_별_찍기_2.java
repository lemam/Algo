import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2439_��_���_2 {
	public static void main(String[] args) throws IOException {
//		ù° �ٿ� �� 1��,
//		��° �ٿ� �� 2��,
//		N��° �ٿ� �� N��
//		������, �������� �������� ������ ���� ���
//		N(1 �� N �� 100)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N - i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		br.close();
	}
}
