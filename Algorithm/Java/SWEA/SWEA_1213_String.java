
import java.util.Scanner;

/*
 * SWEA 1213번 - String (D3)
 * 
 * 주어지는 영어 문장에서 특정한 문자열의 개수를 반환하는 프로그램을 작성하여라.
 */

public class SWEA_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt(); // 테스트 케이스 번호
			String word = sc.next(); // 특정한 문자열
			String str = sc.next(); // 영어 문장

			int cnt = 0; // 특정한 문자열의 개수
			int idx = 0; // 특정한 문자열을 발견한 가장 최근의 인덱스

			// 더이상 발견되지 않을 때까지 반복
			while (idx != -1) {
				// idx+1 부터 word가 있는지 검색하고 있다면 그 위치의 시작 인덱스를 idx에 저장한다.
				idx = str.indexOf(word, idx + 1);

				// 문자열이 존재하면 카운트를 센다.
				if (idx != -1)
					cnt++;
			}

			System.out.printf("#%d %d\n", t, cnt);
		}

		sc.close();
	}
}
