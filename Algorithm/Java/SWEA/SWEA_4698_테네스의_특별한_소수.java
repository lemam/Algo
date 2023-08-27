/*
 * SWEA 4698번 - 테네스의 특별한 소수 (D3)
 * 
 * 소수란 1과 자기 자신만으로 나뉘어 떨어지는 숫자로 작은 것부터 나열하면 2, 3, 5, 7, 11, 13, 17, 19, 23, …같은 수들이 있다.
 * 소수가 D를 포함하면 더욱 더 좋아하여 특별한 소수라고 부르기로 했다.
 * 
 * 예를 들어 D = 3이면 3, 13, 23, … 같은 소수들이 3을 포함하였으므로 테네스는 이런 숫자들을 특별한 소수라고 부를 것이다.
 * 
 * D가 주어질 때, A이상 B이하의 수 중에서 특별한 소수인 것들의 개수를 구하는 프로그램을 작성하라.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_4698_테네스의_특별한_소수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();	// 테스트 케이스

		int[] prime = eratos();	// 1000000 이하의 소수 배열

		for (int tc = 1; tc <= T; tc++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int answer = 0; // 특별한 소수의 개수

			for (int i = 0; i < prime.length; i++) {
				// A이상 B이하의 수이면 특별한 소수인지 확인한다.
				if (prime[i] >= A && prime[i] <= B) {
					// D가 포함되어 있으면 특별한 소수이므로 개수를 추가한다.
					if (checkSpecialPrime(prime[i], D)) {
						answer++;
					}
				} 
				// B를 초과하는 수이면 탐색을 중단한다.
				else if (prime[i] > B) {
					break;
				}
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
		
		sc.close();
	}

	// 자연수 n이 자연수 D를 포함하고 있다면 true를 반환한다.
	private static boolean checkSpecialPrime(int n, int D) {
		String str = Integer.toString(n);
		int len = str.length();

		for (int i = 0; i < len; i++) {
			int num = Character.getNumericValue(str.charAt(i));

			if (num == D)
				return true;
		}

		return false;
	}

	// 에라토스테네스의 체를 이용하여 1000000 이하의 소수를 저장한 배열을 반환한다.
	private static int[] eratos() {
		// 배열 생성 및 초기화
		int[] numbers = new int[1000001];
		
		for (int i = 2; i < numbers.length; i++) {
			numbers[i] = i;
		}

		// 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
		// 자기 자신과 이미 지워진 수는 건너뛴다.
		for (int i = 2; i < numbers.length; i++) {
			// 이미 지워진 수는 스킵한다.
			if (numbers[i] == 0)
				continue;

			// i의 배수의 수를 모두 지운다.
			for (int j = i * 2; j < numbers.length; j += i) {
				numbers[j] = 0;
			}
		}

		// 2부터 시작해서 남아있는 수를 저장한다.
		ArrayList<Integer> prime = new ArrayList<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] != 0) {
				prime.add(numbers[i]);
			}
		}

		// 리스트를 배열로 바꾼다.
		int[] result = new int[prime.size()];

		for (int i = 0; i < result.length; i++) {
			result[i] = prime.get(i);
		}

		return result;
	}
}
