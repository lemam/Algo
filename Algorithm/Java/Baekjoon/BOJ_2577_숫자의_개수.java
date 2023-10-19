import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2577번 - 숫자의 개수 (브론즈 2)
 * 
 * 세 개의 자연수 A, B, C가 주어질 때 
 * A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 
 * 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
 */

public class BOJ_2577_숫자의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int[] countArr = new int[10];	// 1부터 9까지의 숫자가 쓰인 개수 배열
		
		int num = A * B * C;

		while(num > 0) {
			countArr[num % 10]++;
			num /= 10;
		}
		
		for (int cnt : countArr)
			System.out.println(cnt);
		
		br.close();
	}

}
