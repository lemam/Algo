import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ���� 3003�� - ŷ, ��, ��, ���, ����Ʈ, �� (����� 5)
 * 
 * ���� ü���ǰ� �ǽ��� �߰��ߴ�.
 * ������ �ǽ��� ��� �־�����, ��� �ǽ��� ������ �ùٸ��� �ʾҴ�.
 * 
 * ü���� �� 16���� �ǽ��� ����ϸ�, 
 * ŷ 1��, �� 1��, �� 2��, ��� 2��, ����Ʈ 2��, �� 8���� �����Ǿ� �ִ�.
 * 
 * �߰��� ��� �ǽ��� ������ �־����� ��, 
 * �� ���� ���ϰų� ���� �ùٸ� ��Ʈ�� �Ǵ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

public class BOJ_3003_ŷ_��_��_���_����Ʈ_�� {
	public static void main(String[] args) throws IOException {
		int[] black = { 1, 1, 2, 2, 2, 8 };
		int[] white = new int[5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < white.length; i++) {
			white[i] = Integer.parseInt(input[i]);
		}

		br.close();
	}
}
