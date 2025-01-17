package Baekjoon;

import java.io.*;

public class BOJ_20310_타노스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();                 // 입력 문자열
        boolean[] checkErase = new boolean[501];    // 지울 문자 체크
        int zeroCnt = 0, oneCnt = 0;                // 0의 개수, 1의 개수
        int length = str.length();

        // 0과 1의 개수 세기
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '0') zeroCnt++;
            else oneCnt++;
        }

        // 0과 1의 개수를 절반으로 나눈다.
        zeroCnt /= 2;
        oneCnt /= 2;

        // 뒤에서부터 0 지우기
        for (int i = length - 1; i >= 0; i--) {
            if (zeroCnt <= 0) break;
            if (str.charAt(i) == '0') {
                checkErase[i] = true;
                zeroCnt--;
            }
        }

        // 앞에서부터 1 지우기
        for (int i = 0; i < length; i++) {
            if (oneCnt <= 0) break;
            if (str.charAt(i) == '1') {
                checkErase[i] = true;
                oneCnt--;
            }
        }

        // 지운 숫자를 빼고 출력한다.
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (checkErase[i]) continue;
            sb.append(str.charAt(i));
        }

        System.out.println(sb);

        br.close();
    }
}
