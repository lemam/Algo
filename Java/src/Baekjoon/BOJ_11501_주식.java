package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());    // 날의 수
            int[] days = new int[N];    // 날 별 주가 배열

            st = new StringTokenizer(br.readLine());

            // days 배열 입력
            for (int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;    // 가장 큰 시세
            long answer = 0;    // 최대 이익

            // 역방향 탐색
            for (int i = N - 1; i >= 0; i--) {
                if (days[i] > max)              // 새로운 가장 큰 시세를 찾으면 갱신한다.
                    max = days[i];
                else
                    answer += max - days[i];    // 아니라면 현재 시세를 max에 판매한다.
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
