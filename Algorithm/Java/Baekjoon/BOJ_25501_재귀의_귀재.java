/*
 * 백준 25501번 - 재귀의 귀재 (브론즈 2)
 * 
 * 팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다. 
 * 어떤 문자열이 팰린드롬인지 판별하는 문제는 재귀 함수를 이용해 쉽게 해결할 수 있다. 
 * 아래 코드의 isPalindrome 함수는 주어진 문자열이 팰린드롬이면 1, 팰린드롬이 아니면 0을 반환하는 함수다.
 * 
 * 정휘는 위에 작성된 isPalindrome 함수를 이용하여 어떤 문자열이 팰린드롬인지 여부를 판단하려고 한다.
 * 구체적으로는, 문자열 S를 isPalindrome 함수의 인자로 전달하여 팰린드롬 여부를 반환값으로 알아낼 것이다.
 * 더불어 판별하는 과정에서 recursion 함수를 몇 번 호출하는지 셀 것이다.
 * 
 * 정휘를 따라 여러분도 함수의 반환값과 recursion 함수의 호출 횟수를 구해보자.
 * 
 * 각 테스트케이스마다, isPalindrome 함수의 반환값과 recursion 함수의 호출 횟수를 한 줄에 공백으로 구분하여 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_25501_재귀의_귀재 {
	public static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			String S = br.readLine();
			
			cnt = 0;
			
			System.out.println(isPalindrome(S) + " " + cnt);
		}

		br.close();
	}

	// 문자열이 팰린드롬이면 1을 반환, 아니면 0을 반환한다.
	private static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	// 팰린드롬인지 판별하는 재귀 함수 
	// 가운데를 중심으로 같은 거리의 오른쪽 문자와 왼쪽 문자가 같은지 확인한다.
	// 문자열이 팰린드롬이면 1을 반환, 아니면 0을 반환한다.
	// s : 판별할 문자열
	// l : 왼쪽 문자열의 인덱스
	// r : 오른쪽 문자열의 인덱스
	private static int recursion(String s, int l, int r) {
		// 호출한 횟수 세기
		cnt++;
		
		if (l >= r) return 1;
		if (s.charAt(l) != s.charAt(r))	return 0;
		return recursion(s, l + 1, r - 1);
	}
}
