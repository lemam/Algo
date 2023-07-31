import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10951_AB4 {
	public static void main(String[] args) throws IOException {
//		두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램
//		(0 < A, B < 10)
		
//		EOF(End of File) 사용하기
		
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
