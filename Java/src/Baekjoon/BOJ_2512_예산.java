package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 지방의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] costs = new int[N];   // 각 지방의 예산 요청
        int left = 0;   // 이분탐색을 위한 변수들
        int right = -1;

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, costs[i]);
        }

        int total = Integer.parseInt(br.readLine());    // 총 예산

        // 이분 탐색
        while (left <= right) {
            int mid = (left + right) / 2;   // 상한액
            int sum = 0;    // 그 때의 최대값

            // 최대 상한액까지 예산을 배정하여 합한다.
            for (int i = 0; i < N; i++) {
                sum += Math.min(costs[i], mid);
            }

            // 국가예산에 만족하는지 확인
            if (sum <= total) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);

        br.close();
    }
}