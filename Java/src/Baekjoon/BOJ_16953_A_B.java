package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16953_A_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1; // 연산 횟수

        // A와 B가 같아질 때까지 반복
        while (A != B) {
            // A가 B보다 크면
            // B는 만들 수 없는 수
            if (A > B) {
                answer = -1;
                break;
            }

            String str = String.valueOf(B);

            // B가 2로 나눌 수 없고, 마지막 수가 1이 아닌 경우
            // B는 만들 수 없는 수
            if (B % 2 != 0 && str.charAt(str.length() - 1) != '1') {
                answer = -1;
                break;
            }

            // B를 2로 나눌 수 있다면, 2로 나눈다.
            if (B % 2 == 0) {
                B /= 2;
            }
            // B의 마지막 수가 1이라면, 1을 없앤다.
            else {
                str = str.substring(0, str.length() - 1);
                B = Integer.parseInt(str);
            }

            answer++;   // 연산 횟수 증가
        }

        System.out.println(answer);

        br.close();
    }
}
