import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2920번 - 음계 (브론즈 2)
 * 
 * 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 
 * 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. 
 * c는 1로, d는 2로, ..., C를 8로 바꾼다.
 * 
 * 1부터 8까지 차례대로 연주한다면 ascending, 
 * 8부터 1까지 차례대로 연주한다면 descending, 
 * 둘 다 아니라면 mixed 이다.
 * 
 * 연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 */

public class BOJ_2920_음계 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[8];	// 음계 배열
		
		// 음계 입력
		for (int i = 0; i < 8; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		boolean isMixed = false;
		int diff = arr[7] - arr[6];
		
		// arr[i] - arr[i-1]의 값이 달라지면 mixed이다.
		for (int i = 6; i > 0; i--) {
			if (diff != arr[i] - arr[i-1]) {
				isMixed = true;
				break;
			}
		}
		
		if (isMixed) {
			System.out.println("mixed");
		}
		else {
			if (diff == 1)
				System.out.println("ascending");
			else
				System.out.println("descending");
		}
		
		
		br.close();
	}
}
