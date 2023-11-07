import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 27323번 - 직사각형
 * 
 * 정수 A, B 가 주어진다. 
 * 세로 길이가 A cm, 가로 길이가 B cm 인 아래와 같은 직사각형의 넓이를 cm2 단위로 구하시오.
 */

public class BOJ_27323_직사각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(br.readLine()); // 세로 길이
		int B = Integer.parseInt(br.readLine()); // 가로 길이
		
		System.out.println(A * B);

		br.close();
	}
}
