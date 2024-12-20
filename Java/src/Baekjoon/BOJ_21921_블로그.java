package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 블로그를 시작하고 지난 일수
        int X = Integer.parseInt(st.nextToken());   // 최대 방문자를 합할 기간
        int[] visitors = new int[N + 1];    // 방문자 수 배열

        // 방문자 수 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;    // 방문자 수 총합

        // 1일 ~ X일까지의 총 방문자 수 저장
        for (int i = 1; i <= X; i++) sum += visitors[i];

        int max = sum;  // 최대 방문자 수
        int count = 1;  // 최대 방문자 수가 있는 기간의 개수

        for (int i = X + 1; i <= N; i++) {
            // 다음 날을 더하고 이전 기간의 첫 날을 뺀다.
            sum += visitors[i] - visitors[i - X];   // 다음 기간의 방문자 수

            // 최대값이면 갱신한다.
            if (sum > max) {
                max = sum;
                count = 1;
            }
            // 최대값과 같다면 카운팅한다.
            else if (sum == max) {
                count++;
            }
        }

        // 최대 방문자 수가 0명이라면 SAD를 출력한다.
        if (max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(count);
        }

        br.close();
    }
}
