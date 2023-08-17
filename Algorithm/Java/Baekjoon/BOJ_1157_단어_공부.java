import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 1157번 - 단어 공부 (브론즈 1)
 * 
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
 * 단, 대문자와 소문자를 구분하지 않는다.
 * 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
 */

public class BOJ_1157_단어_공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26]; // 알파벳의 개수는 26개
		String str = br.readLine();
		int len = str.length();

		// 알파벳 개수 세기 (대소문자 구분 없이)
		for (int i = 0; i < len; i++) {
			int ch = str.charAt(i);

			if (ch >= 'A' && ch <= 'Z')
				arr[ch - 'A']++;
			else
				arr[ch - 'a']++;
		}

		int max = 0;	// 개수 최댓값
		char ch = '?';	// 많이 사용된 알파벳

		for (int i = 0; i < arr.length; i++) {
			// 만약 많이 사용된 알파벳이 여러 개 존재하면 ?를 출력한다.
			if (max == arr[i])
				ch = '?';
			// 최댓값 탐색
			else if (max < arr[i]) {
				max = arr[i];
				ch = (char) (i + 'A');
			}
		}
		
		System.out.println(ch);

		br.close();
	}
}
