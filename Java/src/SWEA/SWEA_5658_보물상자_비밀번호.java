package SWEA;/*
 * SWEA 5658번 - 보물상자 비밀번호
 * 
 * 각 변에 다음과 같이 16진수 숫자(0~F)가 적혀 있는 보물상자가 있다.
 * 보물 상자의 뚜껑은 시계방향으로 돌릴 수 있고, 
 * 한 번 돌릴 때마다 숫자가 시계방향으로 한 칸씩 회전한다.
 * 
 * 각 변에는 동일한 개수의 숫자가 있고, 시계방향 순으로 높은 자리 숫자에 해당하며 하나의 수를 나타낸다.
 * 
 * 보물상자에는 자물쇠가 걸려있는데, 
 * 이 자물쇠의 비밀번호는 보물 상자에 적힌 숫자로 만들 수 있는 모든 수 중, 
 * K번째로 큰 수를 10진 수로 만든 수이다.
 * 
 * N개의 숫자가 입력으로 주어졌을 때, 보물상자의 비밀 번호를 출력하는 프로그램을 만들어보자.
 * (서로 다른 회전 횟수에서 동일한 수가 중복으로 생성될 수 있다. 크기 순서를 셀 때 같은 수를 중복으로 세지 않도록 주의한다.)
 */

import java.util.*;

public class SWEA_5658_보물상자_비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 숫자의 개수
			int K = sc.nextInt(); // 크기 순서

			String[] numbers = sc.next().split(""); // 숫자 배열

			int size = N / 4; // 한 변의 숫자 개수

			Set<String> pwSet = new HashSet<String>();

			// size번 회전하면 생성 가능한 수가 0회전과 동일해진다.
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < N; j += size) {
					String pw = "";	// 생성 가능한 수
					
					for (int k = 0; k < size; k++) {
						pw += numbers[j + k];
					}
					
					// 중복으로 세지 않기 위해 set에 저장한다.
					pwSet.add(pw);
				}

				// 시계 방향으로 회전
				numbers = rotate(numbers);
			}

			List<String> pwList = new ArrayList<String>(pwSet);
			
//			System.out.println(pwList);

			// 내림차순으로 정렬
			Collections.sort(pwList, Collections.reverseOrder());

			// K번째로 큰 수를 10진수로 변환 후 출력
			System.out.printf("#%d %d\n", tc, Integer.parseInt(pwList.get(K - 1), 16));
		}

		sc.close();
	}

	// 원본 배열의 원소들을 오른쪽으로 한 칸 이동시킨 배열을 반환한다.
	private static String[] rotate(String[] numbers) {
		String[] arr = numbers.clone();
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			arr[i] = numbers[(i + len - 1) % len];
		}

		return arr;
	}
}
