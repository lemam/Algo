import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637_괄호_추가하기 {
	private static int N, answer;
	private static char[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 수식의 길이
		arr = br.readLine().toCharArray(); // 수식 char 배열
		answer = Integer.MIN_VALUE;

		solution(2, arr[0] - '0');
		
		System.out.println(answer);

		br.close();
	}

	private static void solution(int idx, int sum) {
		if (idx >= N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		// 1. 괄호를 안 친 경우
		// 현재까지 계산한 합과 현재 인덱스 숫자를 연산자에 맞춰 계산한다.
		solution(idx + 2, cal(sum, arr[idx] - '0', arr[idx - 1]));

		// 2. 오른쪽으로 괄호를 친 경우
		// 현재 인덱스 숫자가 마지막 숫자가 아니라면
		if (idx + 2 < N) {
			// 괄호 안부터 계산
			int temp = cal(arr[idx] - '0', arr[idx + 2] - '0', arr[idx + 1]);
			// 현재까지 계산한 합과 temp를 계산한다.
			solution(idx+4, cal(sum, temp, arr[idx - 1]));
		}
	}

	private static int cal(int x, int y, char op) {
		if (op == '+')
			return x + y;
		else if (op == '-')
			return x - y;
		else
			return x * y;
	}
}
