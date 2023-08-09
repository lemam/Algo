import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 3052번 - 나머지 (브론즈 2)
 * 
 * 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다.
 * 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.
 * 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 */

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 10; // 입력값 개수
		int[] count = new int[42]; // 나머지 카운트 배열
		int answer = 0;

		// 입력값 저장
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			count[num % 42]++;
		}

		// 서로 다른 값 개수 확인
		for (int cnt : count) {
			if (cnt > 0)
				answer++;
		}

		System.out.println(answer);

		br.close();
	}
}
