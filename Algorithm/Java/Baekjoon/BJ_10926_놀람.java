package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10926_놀람 {

	public static void main(String[] args) throws IOException {
		/*
		 * BJ 10926 ??!
		 * 
		 * 준하의 아이디를 입력 받으면
		 * 아이디 뒤에 "??!"을 붙여 놀람을 표현한다.
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String id = br.readLine();
		
		System.out.println(id + "??!");
	}

}
