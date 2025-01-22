package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());   // 세로 길이
        int W = Integer.parseInt(st.nextToken());   // 가로 길이
        int[] map = new int[W]; // 벽의 높이를 저장할 배열
        int answer = 0;

        // map 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 벽과 마지막 벽은 물이 고일 수 없으므로 1 ~ W-2 범위를 탐색한다.
        for (int i = 1; i < W - 1; i++) {
            int curr = map[i];      // 현재 벽의 높이
            int leftMax = curr;     // 왼쪽 벽 최대 높이
            int rightMax = curr;    // 오른쪽 벽 최대 높이

            // 왼쪽 벽의 최대 높이 탐색
            for (int j = i - 1; j >= 0; j--) {
                if (map[j] > curr) {
                    leftMax = Math.max(leftMax, map[j]);
                }
            }

            // 오른쪽 벽의 최대 높이 탐색
            for (int j = i + 1; j < W; j++) {
                if (map[j] > curr) {
                    rightMax = Math.max(rightMax, map[j]);
                }
            }

            // 고일 빗물 칸의 개수 세기
            int minHeight = Math.min(leftMax, rightMax);    // 왼쪽 벽과 오른쪽 벽 높이 중 낮은 값

            // 현재 벽보다 높은 벽이 양쪽에 있는 경우
            if (minHeight > curr) {
                // 높은 벽과 현재 벽의 높이 차이만큼 빗물이 고인다.
                answer += minHeight - curr;
            }
        }

        System.out.println(answer);

        br.close();
    }
}