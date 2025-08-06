package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11404_플로이드 {
    private static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());   // 도시의 개수
        int m = Integer.parseInt(br.readLine());   // 버스의 개수
        int[][] arr = new int[n + 1][n + 1];       // 버스 정보 배열

        // arr 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = INF;
                if (i == j) arr[i][j] = 0;
            }
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 출발 도시
            int b = Integer.parseInt(st.nextToken());   // 도착 도시
            int c = Integer.parseInt(st.nextToken());   // 비용

            // 출발, 도착 도시가 같지만 비용이 다른 경우가 있으므로
            // 가장 비용이 작은 값을 최종 선택한다.
            arr[a][b] = Math.min(arr[a][b], c);
        }

        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // (i에서 j로 가는 최소 비용) > (i에서 k로 가는 비용 + k에서 j로 가는 비용)
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == INF) {
                    arr[i][j] = 0;
                }

                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
