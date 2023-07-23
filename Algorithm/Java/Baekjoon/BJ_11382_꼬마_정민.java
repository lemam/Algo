package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11382_꼬마_정민 {

	public static void main(String[] args) throws IOException {
		/*
		 * A + B + C
		 * A, B, C (1 ≤ A, B, C ≤ 10^12)
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		System.out.println(A + B + C);
	}

}
