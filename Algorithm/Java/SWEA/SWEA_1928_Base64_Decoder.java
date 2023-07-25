import java.util.Base64;
import java.util.Scanner;

public class SWEA_1928_Base64_Decoder {
	public static void main(String[] args) {
		/*
		 * Encoding 순서
		 * 1. 24비트 버퍼에 왼쪽부터 한 byte씩 3 byte의 문자를 집어 넣는다.
		 * 2. 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 표의 문자로 인코딩한다.
		 * 
		 * 입력으로 Base64 Encoding 된 String 이 주어졌을 때, 
		 * 해당 String 을 Decoding 하여, 원문을 출력하는 프로그램을 작성하시오.
		 * 
		 * 문자열의 길이는 항상 4의 배수로 주어진다.
		 * 그리고 문자열의 길이는 100000을 넘지 않는다.
		 * 
		 * <인코딩 방법>
		 * 1. 표1을 보고 입력받은 문자들을 각각 대응하는 숫자로 변경한다.
		 * 2. 각 숫자들을 6자리 이진수로 표현하고, 이 진수들을 한 줄로 쭉 이어 붙인다.
		 * 3. 한 줄로 쭉 이어붙인 이진수들을 8자리씩 끊어서 10진수로 바꾼다.
		 * 4. 각각의 10진수를 아스키 코드로 변환한다.
		 * 
		 * <라이브러리>
		 * Java에선 java.util.Base64 라이브러리를 통해 인코딩/디코딩을 할 수 있다.
		 * Base64란, 64문자의 영숫자를 이용하여 멀티 바이트 문자열이나 이진 데이터를 다루기 위한 인코딩 방식이다.
		 */

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String encoded = sc.next();
			String decoded = new String(Base64.getDecoder().decode(encoded));
			System.out.printf("#%d %s\n", t, decoded);
		}
		
		sc.close();
	}
}
