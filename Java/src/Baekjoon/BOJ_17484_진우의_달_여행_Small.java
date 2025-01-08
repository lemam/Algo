package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17484_진우의_달_여행_Small {
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 행
        int M = Integer.parseInt(st.nextToken());   // 열
        int[][] map = new int[N][M];    // 지구와 달 사이의 공간 배열
        answer = Integer.MAX_VALUE;

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 지점 4칸을 모두 탐색한다.
        for (int col = 0; col < M; col++) {
            dfs(0, 0, col, -1, map[0][col], map);
        }

        System.out.println(answer);

        br.close();
    }

    private static void dfs(int depth, int row, int col, int prevDir, int cost, int[][] map) {
        // 현재 연료가 이전 최소값보다 크면 더이상 탐색하지 않는다.
        if (cost >= answer) return;

        // 마지막 줄에 도착했다면 탐색을 종료한다.
        if (depth == map.length - 1) {
            answer = Math.min(answer, cost);
            return;
        }

        // 이전에 갔던 방향은 갈 수 없다.
        // 1. 왼쪽으로 이동
        if (prevDir != 1 && col - 1 >= 0)
            dfs(depth + 1, row + 1, col - 1, 1, cost + map[row + 1][col - 1], map);

        // 2. 가운데로 이동
        if (prevDir != 2)
            dfs(depth + 1, row + 1, col, 2, cost + map[row + 1][col], map);

        // 3. 오른쪽으로 이동
        if (prevDir != 3 && col + 1 < map[0].length)
            dfs(depth + 1, row + 1, col + 1, 3, cost + map[row + 1][col + 1], map);
    }
}