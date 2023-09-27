import java.util.Scanner;

/*
 * SWEA 1970번 - 쉬운 거스름돈 (D2)
 * 
 * 우리나라 화폐 ‘원’은 금액이 높은 돈을 우선적으로 계산할 때 돈의 개수가 가장 최소가 된다.
 * 
 * S마켓에서 사용하는 돈의 종류는 다음과 같다.
 * 50,000 원
 * 10,000 원
 * 5,000 원
 * 1,000 원
 * 500 원
 * 100 원
 * 50 원
 * 10 원
 * 
 * S마켓에서 손님에게 거슬러 주어야 할 금액 N이 입력되면 
 * 돈의 최소 개수로 거슬러 주기 위하여 각 종류의 돈이 몇 개씩 필요한지 출력하라.
 */

public class SWEA_1970_쉬운_거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 거스름 돈
			int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 }; // 돈의 종류
			int[] count = new int[money.length]; // 각 종류의 돈의 개수
			
			for (int i = 0; i < money.length; i++) {
				count[i] = N / money[i];	// 거슬러 줄 수 있는 money[i]의 개수 저장
				
				if (count[i] > 0)
					N -= money[i] * count[i];	// 거슬러 준 돈만큼 차감
			}
			
			System.out.println("#" + tc);
			
			for (int i : count)
				System.out.print(i + " ");
			
			System.out.println();
		}

		sc.close();
	}
}
