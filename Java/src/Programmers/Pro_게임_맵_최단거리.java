package Programmers;

import java.util.*;

class Pro_게임_맵_최단거리 {
    public int solution(int[][] maps) {
        // 12, 3, 6, 9
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int N = maps.length;
        int M = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                return now[2];
            }

            // 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = now[0] + dr[dir];
                int nc = now[1] + dc[dir];

                // 맵 밖이거나 벽이거나 방문했던 곳이면 건너뛴다.
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || maps[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc, now[2] + 1});
            }
        }

        return -1;
    }
}