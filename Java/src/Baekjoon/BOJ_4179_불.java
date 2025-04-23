package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4179_불 {
    private static int R, C;
    private static char[][] map;

    // 12 3 6 9
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   // 행의 개수
        C = Integer.parseInt(st.nextToken());   // 열의 개수
        map = new char[R][C];  // 미로 배열

        int[][] jihoonTime = new int[R][C];         // 지훈의 이동 시간 배열
        int[][] fireTime = new int[R][C];           // 불의 이동 시간 배열
        Queue<int[]> jihoon = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();

        // map 입력
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                jihoonTime[i][j] = -1;
                fireTime[i][j] = -1;

                // 지훈이 시작 위치 저장
                if (map[i][j] == 'J') {
                    jihoon.add(new int[]{i, j});
                    jihoonTime[i][j] = 0;
                }
                // 불 난 위치 저장
                else if (map[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
            }
        }

        // 불의 전파 시간 계산
        bfsFire(fire, fireTime);

        // 지훈이 이동
        int answer = bfsJihoon(jihoon, jihoonTime, fireTime);

        // 출력
        if (answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);

        br.close();
    }

    private static int bfsJihoon(Queue<int[]> jihoon, int[][] jihoonTime, int[][] fireTime) {
        while (!jihoon.isEmpty()) {
            int[] curr = jihoon.poll();
            int row = curr[0];
            int col = curr[1];

            // 가장자리이면 탈출
            if (row == 0 || row == R - 1 || col == 0 || col == C - 1) {
                return jihoonTime[row][col] + 1;
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 다음 이동 위치가 미로 범위 밖이면 스킵
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                // 다음 이동 위치가 벽이거나 이미 이동한 곳이면 스킵
                if (map[nr][nc] == '#' || jihoonTime[nr][nc] >= 0) continue;

                // 다음 이동 위치가 불이 퍼질 위치이고,
                // 불이 퍼질 시간보다 지훈이 이동하는 시간이 느리면 스킵
                if (fireTime[nr][nc] != -1 && fireTime[nr][nc] <= jihoonTime[row][col] + 1) continue;

                // 지훈 이동
                jihoonTime[nr][nc] = jihoonTime[row][col] + 1;
                jihoon.add(new int[]{nr, nc});
            }
        }

        return -1;  // 탈출 실패
    }

    private static void bfsFire(Queue<int[]> fire, int[][] fireTime) {
        while (!fire.isEmpty()) {
            int[] cur = fire.poll();
            int row = cur[0];
            int col = cur[1];

            // 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 다음 이동 위치가 미로 범위 밖이면 스킵
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                // 다음 이동 위치가 벽이거나 이미 불이 난 곳은 스킵
                if (map[nr][nc] == '#' || fireTime[nr][nc] >= 0) continue;

                // 불 이동
                fireTime[nr][nc] = fireTime[row][col] + 1;
                fire.add(new int[]{nr, nc});
            }
        }
    }
}
