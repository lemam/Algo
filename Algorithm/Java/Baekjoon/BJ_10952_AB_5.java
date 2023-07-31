import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10952_AB5 {
	public static void main(String[] args) throws IOException {
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
//		(0 < A, B < 10)
//		입력의 마지막에는 0 두 개가 들어온다.

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
