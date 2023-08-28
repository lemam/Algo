/*
 * 백준 10798번 - 세로읽기 (브론즈 1)
 * 
 * 아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다. 
 * 이 장난감에 있는 글자들은 영어 대문자 ‘A’부터 ‘Z’, 영어 소문자 ‘a’부터 ‘z’, 숫자 ‘0’부터 ‘9’이다. 
 * 
 * 영석이는 칠판에 글자들을 수평으로 일렬로 붙여서 단어를 만든다. 
 * 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다.
 * 이런 식으로 다섯 개의 단어를 만든다.
 * 
 * 한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다. 
 * 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다. 
 * 
 * 심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다.
 * 세로로 읽을 때, 각 단어의 첫 번째 글자들을 위에서 아래로 세로로 읽는다. 
 * 다음에 두 번째 글자들을 세로로 읽는다. 
 * 이런 식으로 왼쪽에서 오른쪽으로 한 자리씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
 * 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다. 
 *
 * 칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.
 * 
 * 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다. 
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "";

		int N = 5; // 칠판에 만들어진 단어의 개수
		int M = 15; // 한 줄의 단어의 최대 글자수
		char[][] words = new char[N][M]; // 단어 배열

		// 단어 배열 입력
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			int len = line.length();
			
			for (int j = 0; j < len; j++) {
				words[i][j] = line.charAt(j);
			}
		}
		
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (words[i][j] == '\u0000')
					continue;
				
				answer += words[i][j];
			}
		}
		
		System.out.println(answer);

		br.close();
	}
}
