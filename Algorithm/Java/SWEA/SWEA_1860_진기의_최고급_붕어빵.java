import java.util.Arrays;
import java.util.Scanner;

/*
 * SWEA 1860번 - 진기의 최고급 붕어빵
 * 
 * 진기는 붕어빵 가게를 운영하고 있다.
 * 그는 무조건 예약제로만 손님을 받는다.
 * 오늘은 N명의 사람이 자격을 얻었다.
 * 
 * 진기는 0초부터 붕어빵을 만들기 시작하며, 
 * M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.
 * 붕어빵이 완성되면 어떤 시간 지연도 없이 다음 붕어빵 만들기를 시작할 수 있다.
 * 
 * 0초 이후에 손님들이 언제 도착하는지 주어지면, 
 * 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.
 * 
 * 모든 손님에 대해 기다리는 시간이 없이 붕어빵을 제공할 수 있으면 “Possible”을, 아니라면 “Impossible”을 출력한다.
 */

public class SWEA_1860_진기의_최고급_붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 손님이 도착하는 시간의 개수
			int M = sc.nextInt(); // 붕어빵 하나를 만드는 시간
			int K = sc.nextInt(); // M초의 시간 후에 만들어지는 붕어빵의 개수

			int[] arriveTime = new int[N]; // 손님 도착 시간 배열
			String answer = "Possible";

			// 손님 도착 시간 배열 입력
			for (int i = 0; i < N; i++)
				arriveTime[i] = sc.nextInt();

			// 오름차순으로 정렬
			Arrays.sort(arriveTime);

			for (int i = 0; i < N; i++) {
				// arriveTime[i]초까지 만들어진 붕어빵의 개수
				int bread = (arriveTime[i] / M) * K;
				// i+1번 째 사람이 사가고 남은 붕어빵의 개수
				int remain = bread - (i + 1);

				// 음수이면 손님에게 바로 제공할 붕어빵이 없는 것이므로 불가능하다.
				if (remain < 0) {
					answer = "Impossible";
					break;
				}
			}

			System.out.printf("#%d %s\n", tc, answer);
		}

		sc.close();
	}
}
