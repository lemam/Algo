import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의_이동 {
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    // 나이트가 이동할 수 있는 8방향
    private static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());    // 테스트 케이스

        StringTokenizer st = null;

        for (int tc = 0; tc < TC; tc++) {
            N = Integer.parseInt(br.readLine());    // 체스판의 한 변의 길이
            map = new int[N][N];    // 체스판 배열
            visited = new boolean[N][N];    // 방문 배열

            st = new StringTokenizer(br.readLine());
            int currRow = Integer.parseInt(st.nextToken());
            int currCol = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int destRow = Integer.parseInt(st.nextToken());
            int destCol = Integer.parseInt(st.nextToken());

            // bfs
            solution(currRow, currCol, destRow, destCol);

            System.out.println(map[destRow][destCol]);
        }

        br.close();
    }

    private static void solution(int currRow, int currCol, int destRow, int destCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{currRow, currCol});
        visited[currRow][currCol] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];

            // 이동하려는 칸에 도착하면 종료한다.
            if (row == destRow && col == destCol) {
                return;
            }

            // 8방향 탐색
            for (int dir = 0; dir < 8; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 범위 밖이거나 이미 방문한 곳이면 건너뛴다.
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) {
                    continue;
                }

                // 큐에 넣기
                queue.add(new int[]{nr, nc});
                map[nr][nc] = map[row][col] + 1;
                visited[nr][nc] = true;
            }
        }
    }
}
