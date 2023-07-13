import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		/*
		 * <진짜 약수 A 조건>
		 * 1. N = A의 배수
		 * 2. A != 1 그리고 N
		 * 
		 * 어떤 수  N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(st.nextToken());
			max = num > max ? num : max;
			min = num < min ? num : min;
		}
		
		System.out.println(max * min);
	}

}
