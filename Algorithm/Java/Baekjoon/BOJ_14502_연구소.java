import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    private static int N, M, answer;
    private static int[][] map;

    // 12, 3, 6, 9
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectWalls(0);

        System.out.println(answer);

        br.close();
    }

    private static void selectWalls(int wallCnt) {
        // 벽 3개를 설치하면 안전 구역을 탐색한다.
        if (wallCnt == 3) {
            countSafeArea();
            return;
        }

        // 벽 설치하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;  // 벽 설치
                    selectWalls(wallCnt + 1);
                    map[i][j] = 0;  // 원상복구
                }
            }
        }
    }

    private static void countSafeArea() {
        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 칸을 큐에 넣는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        // map 배열 복사
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            for (int dir = 0; dir < 4; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 연구소 범위 밖이거나 빈칸이 아니면 건너뛴다.
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || copyMap[nr][nc] != 0) {
                    continue;
                }

                // 바이러스 퍼뜨리기
                queue.add(new int[]{nr, nc});
                copyMap[nr][nc] = 2;
            }
        }

        // 안전구역 개수 세기
        int safeCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeCnt++;
                }
            }
        }

        // 최댓값 갱신
        answer = Math.max(safeCnt, answer);
    }
}
