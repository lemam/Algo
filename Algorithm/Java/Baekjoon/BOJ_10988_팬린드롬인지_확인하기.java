import java.util.Scanner;

/*
 * 백준 10988번 - 팰린드롬인지 확인하기 (브론즈 2)
 * 
 * 알파벳 소문자로만 이루어진 단어가 주어진다.
 * 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
 * 
 * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
 * 팰린드롬이면 1, 아니면 0을 출력한다.
 */

public class BOJ_10988_팬린드롬인지_확인하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int len = str.length();
		int answer = 1;

		// 팬린드롬 확인하기
		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - 1 - i)) {
				answer = 0;
				break;
			}
		}
		
		System.out.println(answer);

		sc.close();
	}
}
