package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13305_주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 도시의 개수

        long[] dist = new long[N - 1];  // 도로의 거리
        long[] cost = new long[N];  // 주유소 비용

        // dist 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        // cost 배열 입력
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;   // 총 금액
        long minCost = cost[0]; // 이전 과정 중 주유 최소 비용

        // 마지막 도시는 볼 필요 없으므로 N-2까지 탐색한다.
        // 리터 당 기름 값이 내림차순일 경우에 주유한다.
        for (int i = 0; i < N - 1; i++) {
            // 현재 주유소가 이전 주유소보다 기름값이 싼 경우
            // minCost를 갱신해준다.
            if (cost[i] < minCost) minCost = cost[i];

            // (최소 기름값 * 다음 도시까지의 길이)만큼 더해준다.
            sum += minCost * dist[i];
        }

        System.out.println(sum);

        br.close();
    }
}
