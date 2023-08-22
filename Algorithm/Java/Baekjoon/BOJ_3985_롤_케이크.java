/*
 * 백준 3985번 - 롤 케이크 (브론즈 1)
 * 
 * 길이 L미터의 롤 케이크를 만들 것이다.
 * 스튜디오의 방청객 N명에게 케이크를 나누어 주려고 한다.
 * 
 * 상근이는 롤 케이크를 펼쳐서 1미터 단위로 잘라 놓았다.
 * 가장 왼쪽 조각이 1번, 오른쪽 조각이 L번 조각이다.
 * 
 * 방청객은 1번부터 N번까지 번호가 매겨져 있다. 
 * 각 방청객은 종이에 자신이 원하는 조각을 적어서 낸다.
 * 이때, 두 수 P와 K를 적어서 내며, P번 조각부터 K번 조각을 원한다는 뜻이다.
 * 
 * 1번 방청객의 종이부터 순서대로 펼쳐서 해당하는 조각에 그 사람의 번호를 적을 것이다.
 * 이미 번호가 적혀있는 조각은 번호를 적지 못하고 넘어간다.
 * 이런 방식을 이용해서 방청객에게 조각을 주다보니, 자신이 원래 원했던 조각을 받지 못하는 경우가 생길 수 있다.
 * 
 * 가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호와
 * 실제로 가장 많은 케이크 조각을 받는 방청객의 번호를 구하는 프로그램을 작성하시오.
 * 각 경우에 조건을 만족하는 방청객이 두 명 이상이라면 그중 번호가 가장 작은 방청객의 번호를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3985_롤_케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 롤 케이크의 길이
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int[] cake = new int[L + 1]; // 롤 케이크

		int expNum = 0; // 가장 많은 케이크 조각을 받을 것으로 기대한 방청객의 번호
		int expCnt = 0; // 그 방청객의 케이크 조각 개수
		int resultNum = 0; // 실제로 가장 많은 케이크 조각을 받는 방청객의 번호
		int resultCnt = 0; // 그 방청객의 케이크 조각 개수

		// 모든 방청객 탐색
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 종이에 적어낸 수
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 최대 기대값 저장
			if (expCnt < K - P) {
				expCnt = K - P;
				expNum = i;
			}

			// 롤케이크에 방청객 번호 적기
			for (int j = P; j <= K; j++) {
				// 이미 번호가 적혀있는 조각은 번호를 적지 못하고 넘어간다.
				if (cake[j] != 0)
					continue;

				cake[j] = i;
			}
		}

		int[] count = new int[N + 1];

		// 롤케이크에 적힌 번호 개수 세기
		for (int i = 1; i <= L; i++) {
			count[cake[i]]++;
		}

		// 최대 결과값 저장
		for (int i = 1; i <= N; i++) {
			if (resultCnt < count[i]) {
				resultCnt = count[i];
				resultNum = i;
			}
		}

		System.out.println(expNum);
		System.out.println(resultNum);

		br.close();
	}
}
