package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1446_지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 지름길의 개수
        int D = Integer.parseInt(st.nextToken());   // 고속도로의 길이
        int[][] arr = new int[N][3];    // 지름길 정보 배열

        // arr 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[D + 1];  // 각 거리에 도달할 때 운전한 거리 최소값 배열

        // dp 초기화
        // 지름길 없이 각 거리에 도달할 때 운전해야 하는 최소값을 넣어준다.
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= D; i++) {
            // (1) 현 위치까지의 운전 거리
            // (2) 이전 위치까지의 운전 거리 + 1
            // 중 최소값을 dp에 저장한다.
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            // 지름길을 통해 현 위치(i)에 도달할 수 있는 경우가 있는지 확인한다.
            for (int j = 0; j < N; j++) {
                // 지름길의 도착점이 현 위치인 경우
                if (arr[j][1] == i) {
                    // (1) 현 위치까지의 운전 거리
                    // (2) 지름길 시작지점까지의 운전 거리 + 지름길의 거리
                    // 중 최소값을 dp에 저장한다.
                    dp[i] = Math.min(dp[i], dp[arr[j][0]] + arr[j][2]);
                }
            }
        }

        // 도착지점의 운전 거리 최소값을 출력한다.
        System.out.println(dp[D]);

        br.close();
    }
}
