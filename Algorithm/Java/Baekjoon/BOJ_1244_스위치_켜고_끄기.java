import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 1244번 - 스위치 켜고 끄기 (실버 4)
 * 
 * 1부터 연속적으로 번호가 붙어있는 스위치들이 있다.
 * 스위치는 켜져 있거나 꺼져있는 상태이다.
 * 
 * ‘1’은 스위치가 켜져 있음을, ‘0’은 꺼져 있음을 나타낸다.
 * 그리고 학생 몇 명을 뽑아서, 학생들에게 1 이상이고 스위치 개수 이하인 자연수를 하나씩 나누어주었다.
 * 학생들은 자신의 성별과 받은 수에 따라 아래와 같은 방식으로 스위치를 조작하게 된다.
 * 
 * 남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다.
 * 즉, 스위치가 켜져 있으면 끄고, 꺼져 있으면 켠다.
 * 
 * 여학생은 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로
 * 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서,
 * 그 구간에 속한 스위치의 상태를 모두 바꾼다.
 * 이때 구간에 속한 스위치 개수는 항상 홀수가 된다.
 * 남학생은 1로, 여학생은 2로 표시
 * 
 * 입력으로 스위치들의 처음 상태가 주어지고, 각 학생의 성별과 받은 수가 주어진다.
 * 학생들은 입력되는 순서대로 자기의 성별과 받은 수에 따라 스위치의 상태를 바꾸었을 때,
 * 스위치들의 마지막 상태를 출력하는 프로그램을 작성하시오.
 * 
 * 스위치의 상태를 1번 스위치에서 시작하여 마지막 스위치까지 한 줄에 20개씩 출력한다. 
 * 예를 들어 21번 스위치가 있다면 이 스위치의 상태는 둘째 줄 맨 앞에 출력한다.
 */

public class BOJ_1244_스위치_켜고_끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 스위치의 개수
		int[] switches = new int[N + 1]; // 스위치 상태 배열

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 스위치 상태 배열 입력
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int S = Integer.parseInt(br.readLine()); // 학생 수

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 학생 성별
			int number = Integer.parseInt(st.nextToken()); // 학생이 받은 수

			// 규칙에 따라 스위치 상태 바꾸기
			switches = solution(switches, gender, number);
		}

		for (int i = 1; i <= N; i++) {
			System.out.print(switches[i] + " ");

			// 한 줄에 20개씩 출력한다.
			if (i % 20 == 0)
				System.out.println();
		}

		br.close();
	}

	// 성별(gender)과 받은 수(number)에 따라 스위치를 조작한 배열을 반환한다.
	public static int[] solution(int[] switches, int gender, int number) {
		// 남학생인 경우
		if (gender == 1) {
			// 자기가 받은 수의 배수인 스위치의 상태를 바꾼다.
			for (int i = number; i < switches.length; i += number) {
				switches[i] = (switches[i] + 1) % 2;
			}
		}
		// 여학생인 경우
		else if (gender == 2) {
			int dist = 0; // 중심에서부터의 거리

			// 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾는다.
			for (int i = 1; i < number; i++) {
				int st = number - i;
				int ed = number + i;

				// 범위 밖이면 중단한다.
				if (st < 0 || ed >= switches.length)
					break;
				
				// 대칭이 아니면 중단한다.
				if (switches[st] != switches[ed])
					break;

				dist = i;
			}

			// 그 구간에 속한 스위치의 상태를 모두 바꾼다.
			for (int i = number - dist; i <= number + dist; i++) {
				switches[i] = (switches[i] + 1) % 2;
			}
		}

		return switches;
	}
}
