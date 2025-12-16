package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21758_꿀_따기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 장소의 수
        int[] honey = new int[N];                   // 꿀 배열
        int[] prefix = new int[N];                  // 누적합 배열
        int max = 0;

        // 1. honey 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 누적합 계산
        prefix[0] = honey[0];

        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + honey[i];
        }

        // 3. 3가지 경우를 확인한다.

        // 1) 벌(0) - 벌(i) - 벌통(N-1)
        // 가장 왼쪽에 벌을 놓고, 가장 오른쪽에 벌통을 놓는 것이 이득
        // 반복문으로 나머지 벌의 위치를 탐색한다.
        for (int i = 1; i < N - 1; i++) {
            // 첫번째 벌의 누적값 + 두 번째 벌의 누적값
            int sum = (prefix[N - 1] - honey[0] - honey[i]) + (prefix[N - 1] - prefix[i]);
            max = Math.max(max, sum);
        }

        // 2) 벌(0) - 벌통(i) - 벌(N-1)
        // 가장 왼쪽과 오른쪽에 벌을 놓는 것이 이득
        // 반복문으로 벌통의 위치를 탐색한다.
        for (int i = 1; i < N - 1; i++) {
            int sum = (prefix[i] - honey[0]) + (prefix[N - 2] - prefix[i - 1]);
            max = Math.max(max, sum);
        }

        // 3) 벌통(0) - 벌(i) - 벌(N-1)
        // 가장 오른쪽에 벌을 놓고, 가장 왼쪽에 벌통을 놓는 것이 이득
        // 반복문으로 나머지 벌의 위치를 탐색한다.
        for (int i = 1; i < N - 1; i++) {
            int sum = prefix[i - 1] + (prefix[N - 2] - honey[i]);
            max = Math.max(max, sum);
        }

        System.out.println(max);

        br.close();
    }
}