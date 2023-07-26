import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14681_사분면_고르기 {
	public static void main(String[] args) throws IOException {
		/*
		 * 주어진 점이 어느 사분면에 속하는지 알아내기
		 * 제1사분면 : + +
		 * 제2사분면 : - +
		 * 제3사분면 : - -
		 * 제4사분면 : + -
		 * 
		 * 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내기
		 * (−1000 ≤ x ≤ 1000; x ≠ 0)
		 * (−1000 ≤ y ≤ 1000; y ≠ 0)
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		if (x > 0) {
			if (y > 0)
				System.out.println(1);
			else if (y < 0)
				System.out.println(4);
		}
		else {
			if (y > 0)
				System.out.println(2);
			else if (y < 0)
				System.out.println(3);
		}
	}
}
