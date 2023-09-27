import java.util.Scanner;

/*
 * SWEA 1926번 - 간단한 369 (D2)
 * 
 * 3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
 * 
 * 1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
 * 
 * 2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 
 * 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.  
 * 
 * 입력으로 정수 N 이 주어졌을 때, 1~N 까지의 숫자를 게임 규칙에 맞게 출력하는 프로그램을 작성하라.
 * 박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
 * 여기서 주의해야 할 것은 박수 한 번 칠 때는 - 이며, 박수를 두 번 칠 때는 - - 가 아닌 -- 이다. 
 */

public class SWEA_1926_간단한_369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자의 개수

		// 1부터 N까지의 숫자 말하기
		for (int i = 1; i <= N; i++)
			System.out.print(play(i + "") + " ");

		sc.close();
	}

	// 입력받은 값을 369게임의 규칙에 맞게 변환하여 반환한다.
	// str : 말할 숫자
	private static String play(String str) {
		String result = "";
		int len = str.length();
		int cnt = 0; // 3, 6, 9의 개수

		for (int i = 0; i < len; i++) {
			char ch = str.charAt(i); // i번째 자릿수

			// 3, 6, 9의 개수를 센다.
			if (ch == '3' || ch == '6' || ch == '9')
				cnt++;
		}

		// 3, 6, 9가 없다면 숫자를 말한다.
		if (cnt == 0)
			return str;

		// 3, 6, 9가 있는 개수만큼 박수를 친다.
		for (int i = 0; i < cnt; i++)
			result += "-";

		return result;
	}
}
