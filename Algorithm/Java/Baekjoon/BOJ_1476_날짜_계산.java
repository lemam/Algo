import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜_계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int year = 1;
		
		while(true) {
			if ((year - E) % 15 == 0 && (year - S) % 28 == 0 && (year - M) % 19 == 0) {
				break;
			}
			year++;
		}
		
		System.out.println(year);
		
		br.close();
	}
}
