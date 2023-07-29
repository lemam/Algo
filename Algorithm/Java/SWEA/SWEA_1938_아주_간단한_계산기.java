import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		/*
		 * 두 개의 자연수를 입력받아 사칙연산 수행
		 * (1 ≤ a, b ≤ 9)
		 * 
		 * 사칙연산 + , - , * , / 순서로 연산한 결과를 출력
		 * 나누기 연산의 결과에서 소수점 이하의 숫자는 버린다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		
		sc.close();
	}

}
