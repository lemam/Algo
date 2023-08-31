import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 4779번 - 칸토어 집합 (실버 3)
 * 
 * 칸토어 집합은 0과 1사이의 실수로 이루어진 집합으로, 
 * 구간 [0, 1]에서 시작해서 각 구간을 3등분하여 가운데 구간을 반복적으로 제외하는 방식으로 만든다.
 * 
 * 전체 집합이 유한이라고 가정하고, 다음과 같은 과정을 통해서 칸토어 집합의 근사를 만들어보자.
 * 1. -가 3N개 있는 문자열에서 시작한다.
 * 2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
 * 3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 
 * 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.
 * 
 * N이 주어졌을 때, 마지막 과정이 끝난 후 결과를 출력하는 프로그램을 작성하시오.
 * 
 * 각 줄에 N이 주어진다. 파일의 끝에서 입력을 멈춘다.
 * 입력으로 주어진 N에 대해서, 해당하는 칸토어 집합의 근사를 출력한다. 
 */

public class BOJ_4779_칸토어_집합 {
	public static char[] str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";

		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			str = new char[(int) Math.pow(3, N)]; // 3^N개의 문자 배열

			// 배열 할당
			for (int i = 0; i < str.length; i++) {
				str[i] = '-';
			}

			// 칸토어 집합의 근사 생성
			cantorianSet(0, str.length - 1);

			for (char ch : str) {
				bw.write(ch);
			}
			
			bw.newLine();
			bw.flush();
		}
		
		br.close();
		bw.close();
	}

	// 칸토어 집합의 근사 생성
	private static void cantorianSet(int st, int ed) {
		if (st >= ed) return;

		int len = ed - st + 1; // 탐색 문자열 길이
		int parts = len / 3; // 3등분한 문자열 길이
		int idx = st + parts; // 3등분 중 가운데 문자열 시작 위치

		// 3등분한 문자열 길이만큼 공백 추가
		for (int i = idx; i < idx + parts; i++) {
			str[i] = ' ';
		}

		// 앞의 문자열 탐색
		cantorianSet(st, idx - 1);
		// 뒤의 문자열 탐색
		cantorianSet(idx + parts, ed);
	}
}
