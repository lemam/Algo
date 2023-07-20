package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_19535_수학은_비대면강의입니다 {

	public static void main(String[] args) throws IOException {
		/*
		 * 문자가 2개인 연립방정식 
		 * ax + by = c 
		 * dx + ey = f
		 * 
		 * 문제에서 언급한 방정식을 만족하는 (x, y)가 유일하게 존재 
		 * (-999 <= a,b,c,d,e,f <= 999) 
		 * (-999 < x, y < 999)
		 * 
		 * x와 y를 출력
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		// 1) 완전 탐색
//		out:for (int x = -999; x <= 999; x++) {
//				for (int y = -999; y <= 999; y++) {
//					if (a * x + b * y == c && d * x + e * y == f) {
//						System.out.println(x + " " + y);
//						break out;
//					}
//				}
//		}

		// 2) 연립 방정식
		/*
		 * ax + by = c 
		 * dx + ey = f 
		 * 위 식에 d를, 아래 식에 a를 곱한다.
		 * 
		 * adx + bdy = cd 
		 * adx + aey = af 
		 * 두 식을 빼서 x를 없앤다.
		 * 
		 * bdy - aey = cd - af 
		 * (bd - ae)y = cd - af 
		 * y = (cd - af) / (bd - ae) 
		 * 같은 방법으로 x를 구한다.
		 * 
		 * x = (ce - bf) / (ae - bd)
		 */

		int x = (c * e - b * f) / (a * e - b * d);
		int y = (c * d - a * f) / (b * d - a * e);
		
		System.out.println(x + " " + y);
	}

}
