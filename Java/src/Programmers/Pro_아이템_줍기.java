package Programmers;

import java.util.*;

class Pro_아이템_줍기 {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];

        // 테두리가 겹치지 않도록 좌표에 2배 해주기
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                rectangle[i][j] *= 2;
            }
        }

        // map에 직사각형 저장 (1: 모서리, 2: 내부)
        for (int[] rect : rectangle) {
            for (int i = rect[1]; i <= rect[3]; i++) {
                for (int j = rect[0]; j <= rect[2]; j++) {
                    if ((i == rect[1] || i == rect[3] || j == rect[0] || j == rect[2]) && map[i][j] != 2) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        // BFS
        int answer = bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2, map);

        return answer;
    }

    private int bfs(int cx, int cy, int ix, int iy, int[][] map) {
        // 12 3 6 9
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visisted = new boolean[102][102];

        queue.add(new int[]{cy, cx, 0});
        visisted[cy][cx] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 아이템에 도착하면 탐색을 종료한다.
            // 2배를 했으므로 2로 나누어 반환한다.
            if (curr[0] == iy && curr[1] == ix) return curr[2] / 2;

            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];

                // 범위 밖이거나 테두리가 아니거나 이미 방문한 적이 있으면 건너뛴다.
                if (nr < 0 || nc < 0 || nr >= 102 || nc >= 102 || map[nr][nc] != 1 || visisted[nr][nc]) {
                    continue;
                }

                queue.add(new int[]{nr, nc, curr[2] + 1});
                visisted[nr][nc] = true;
            }
        }

        return 0;
    }
}
