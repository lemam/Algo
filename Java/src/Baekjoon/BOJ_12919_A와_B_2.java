package Baekjoon;

import java.io.*;

public class BOJ_12919_A와_B_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();   // 변환할 문자열
        String T = br.readLine();   // 목표 문자열

        int answer = convert(S, T);

        System.out.println(answer);

        br.close();
    }

    private static int convert(String src, String dest) {
        // 변환한 문자열이 목표 문자열 길이가 같아지면 재귀를 종료한다.
        if (src.length() >= dest.length()) {
            return src.equals(dest) ? 1 : 0;
        }

        int result = 0;

        // 1. 문자열의 뒤에 A를 추가한다.
        // dest의 마지막 글자가 A이면 삭제한다.
        if (dest.charAt(dest.length() - 1) == 'A') {
            result += convert(src, dest.substring(0, dest.length() - 1));
        }

        // 2. 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
        // dest의 첫 글자가 B이면 첫글자를 제외한 나머지 문자를 뒤집는다.
        if (dest.charAt(0) == 'B') {
            String subString = dest.substring(1);
            StringBuilder sb = new StringBuilder(subString);
            result += convert(src, sb.reverse().toString());
        }

        return result > 0 ? 1 : 0;
    }
}

