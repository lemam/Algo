import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		/*
		 * A와  B가 가위바위보를 한다.
		 * 가위 = 1, 바위 = 2, 보 = 3
		 * A와 B 중에 누가 이겼는지 판별
		 * 단, 비기는 경우는 없다. 
		 */
		
		/*
		 * A가 이기는 법
		 * 1 -> 3
		 * 2 -> 1
		 * 3 -> 2
		 */
	
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(A % 3);
		System.out.println((B + 1) % 3);
		
		if (A % 3 == (B + 1) % 3) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		
		sc.close();
	}

}
