package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_18108_1998년생인_내가_태국에서는_2541년생 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		 * 태국은 불멸기원, 즉 석가모니가 열반한 해를 기준으로 연도를 세는 불기를 사용한다.
		 * 우리나라는 서기 연도를 사용한다.
		 * 불기 연도가 주어질 때 이를 서기 연도로 바꿔주는 프로그램 작성
		 * 
		 * 불기 연도 y가 주어진다. (1000 ≤ y ≤ 3000)
		 */
		
		/*
		 * 불기 원년(1년)은 서기년 545년
		 * 불기 = 서기 + 543
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int y = Integer.parseInt(br.readLine());
		
		System.out.println(y - 543);
	}

}
