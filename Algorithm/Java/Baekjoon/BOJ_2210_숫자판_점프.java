import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210_숫자판_점프 {
    private static int[][] map;
    private static Set<Integer> set;

    // 12 3 6 9
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[5][5];
        set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                solution(1, map[i][j], i, j);
            }
        }

        System.out.println(set.size());

        br.close();
    }

    private static void solution(int count, int num, int row, int col) {
        // 숫자 6개를 선택한 경우
        if (count == 6) {
            set.add(num);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) {
                continue;
            }

            solution(count + 1, num * 10 + map[nr][nc], nr, nc);
        }
    }
}
