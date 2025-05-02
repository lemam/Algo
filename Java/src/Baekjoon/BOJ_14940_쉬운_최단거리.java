package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14940_쉬운_최단거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 세로의 크기
        int m = Integer.parseInt(st.nextToken());   // 가로의 크기
        int[][] map = new int[n][m];    // 지도 배열
        int[][] result = new int[n][m]; // 이동 거리 배열
        int[] start = new int[2];   // 시작 지점

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        // map 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 갈 수 없는 땅 저장
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
                // 시작 지점 저장
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        // BFS 수행
        queue.add(start);
        visited[start[0]][start[1]] = true;

        // 12 3 6 9
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];

                // 범위 밖이면 스킵한다.
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                // 이미 방문한 위치거나 지도에서 갈 수 없는 땅(0)이면 스킵한다.
                if (visited[nr][nc] || map[nr][nc] == 0) continue;

                // 현재 위치가 지도에서 갈 수 있는 땅(1)이면 이동 거리를 저장한다.
                visited[nr][nc] = true;
                result[nr][nc] = result[curr[0]][curr[1]] + 1;
                queue.add(new int[]{nr, nc});
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 가지 못한 땅들을 -1로 채워준다.
                if (!visited[i][j]) result[i][j] = -1;
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
