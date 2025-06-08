package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 줄의 개수
        int[][] arr = new int[N][3];

        // arr 입력
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최대값, 최소값 dp 배열
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];

        // 초기화 - 첫 번째 줄은 자기 자신
        max[0] = arr[0].clone();
        min[0] = arr[0].clone();

        // min의 경우 가장 큰 값으로 채운다.
        for (int i = 1; i < N; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        // dp 수행
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < 3; j++) {
                int maxSum, minSum;

                // 왼쪽 대각선으로 내려간 경우
                if (j > 0) {
                    maxSum = max[i][j] + arr[i + 1][j - 1];
                    max[i + 1][j - 1] = Math.max(max[i + 1][j - 1], maxSum);

                    minSum = min[i][j] + arr[i + 1][j - 1];
                    min[i + 1][j - 1] = Math.min(min[i + 1][j - 1], minSum);
                }

                // 바로 아래로 내려간 경우
                maxSum = max[i][j] + arr[i + 1][j];
                max[i + 1][j] = Math.max(max[i + 1][j], maxSum);

                minSum = min[i][j] + arr[i + 1][j];
                min[i + 1][j] = Math.min(min[i + 1][j], minSum);

                // 오른쪽 대각선으로 내려간 경우
                if (j < 2) {
                    maxSum = max[i][j] + arr[i + 1][j + 1];
                    max[i + 1][j + 1] = Math.max(max[i + 1][j + 1], maxSum);

                    minSum = min[i][j] + arr[i + 1][j + 1];
                    min[i + 1][j + 1] = Math.min(min[i + 1][j + 1], minSum);
                }
            }
        }

        // 출력
        int maxResult = 0;
        int minResult = Integer.MAX_VALUE;

        // 마지막 줄에서 최대값 찾기
        for (int i = 0; i < 3; i++) {
            maxResult = Math.max(maxResult, max[N - 1][i]);
        }

        // 마지막 줄에서 최소값 찾기
        for (int i = 0; i < 3; i++) {
            minResult = Math.min(minResult, min[N - 1][i]);
        }

        System.out.println(maxResult + " " + minResult);

        br.close();
    }
}
