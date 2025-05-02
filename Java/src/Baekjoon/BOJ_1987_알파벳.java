package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1987_알파벳 {
    private static int R, C, answer;
    private static char[][] board;
    private static Set<Character> visited;

    // 12 3 6 9
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new HashSet<>();  // 지나간 알파벳을 저장할 HashSet
        answer = 0; // 최대 이동 칸 수

        // board 입력
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 좌측 상단 칸부터 탐색
        visited.add(board[0][0]);
        dfs(1, 0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void dfs(int depth, int row, int col) {
        answer = Math.max(answer, depth);

        // 4방 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            // 범위 밖이거나 이미 지나간 알파벳이면 스킵
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited.contains(board[nr][nc])) {
                continue;
            }

            visited.add(board[nr][nc]);
            dfs(depth + 1, nr, nc);
            visited.remove(board[nr][nc]);
        }
    }
}
