import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		/*
		 * 1000명의 수학 성적의 최빈수를 출력
		 * 단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라
		 * (최빈수: 특정 자료에서 가장 여러 번 나타나는 값)
		 * 
		 * ex)
		 * 10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
		 * 의 최빈수는 8
		 */
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int tc = sc.nextInt();
			int[] countList = new int[101];
			int maxNum = 0;
			int maxIdx = 0;
			
			Arrays.fill(countList, 0);
			
			for (int j = 0; j < 1000; j++) {
				int num = sc.nextInt();
				countList[num] += 1;
			}
			
			for (int k = 0; k < countList.length; k++) {
				if (maxNum <= countList[k]) {
					maxNum = countList[k];
					maxIdx = k;
				}
			}
			
			System.out.printf("#%d %d\n", tc, maxIdx);
		}
	}
}