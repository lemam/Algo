import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 백준 2941번 - 크로아티아 알파벳 (실버 5)
 * 
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 
 * 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 * 
 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * 
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
 * 목록에 없는 알파벳은 한 글자씩 센다.
 */

public class BOJ_2941_크로아티아_알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] alphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		String str = br.readLine();
		
		for (int i = 0; i < alphabet.length; i++) {
			if (str.contains(alphabet[i]))
				str = str.replace(alphabet[i], "*");
		}
		
		System.out.println(str.length());

		br.close();
	}
}
