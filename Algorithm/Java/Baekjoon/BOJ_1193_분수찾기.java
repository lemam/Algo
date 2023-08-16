import java.util.Scanner;

/*
 * 백준 1193번 - 분수찾기 (실버 5)
 * 무한히 큰 배열에 다음과 같이 분수들이 적혀있다.
 * 
 * 이와 같이 나열된 분수들을 1/1 → 1/2 → 2/1 → 3/1 → 2/2 → … 과 같은 
 * 지그재그 순서로 차례대로 1번, 2번, 3번, 4번, 5번, … 분수라고 하자.
 * 
 * X가 주어졌을 때, X번째 분수를 구하는 프로그램을 작성하시오.
 */

public class BOJ_1193_분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		// X가 몇 단째 대각선에 있는지 확인
		int N = 1; // 대각선의 단 수
		int maxNum = 1; // n단의 최대 번호

		while (X > maxNum) {
			maxNum += ++N;
		}

		int diff = maxNum - X; // n단의 최대 번호와 X와의 차

		// N이 홀수이면 최대번호의 분수는 N/1이다.
		// maxNum에서 번호가 줄어들수록 분수가 1씩 감소하고, 분모가 1씩 증가한다.
		if (N % 2 == 1) {
			int denom = 1 + diff; // 분모
			int numer = N - diff; // 분자
			System.out.println(denom + "/" + numer);
		}
		// N이 홀수이면 최대번호의 분수는 1/N이다.
		// maxNum에서 번호가 줄어들수록 분수가 1씩 증가하고, 분모가 1씩 감소한다.
		else {
			int denom = N - diff; // 분모
			int numer = 1 + diff; // 분자
			System.out.println(denom + "/" + numer);
		}

		sc.close();
	}
}
