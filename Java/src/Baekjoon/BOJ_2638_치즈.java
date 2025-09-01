package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2638_치즈 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;

    private static ArrayList<int[]> cheeseList;
    private static int cheeseCnt = 0;

    // 12 3 6 9
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 모눈종이 크기
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cheeseList = new ArrayList<>(); // 치즈 위치 리스트

        // 모눈종이 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 치즈 위치 저장
                if (map[i][j] == 1) {
                    cheeseList.add(new int[]{i, j});
                    cheeseCnt++;
                }
            }
        }

        int time = 0;   // 흐른 시간

        while (cheeseCnt != 0) {
            time++;
            visited = new boolean[N][M];

            // 외부 공기 찾기
            dfs(0, 0);

            // 치즈 녹이기
            meltCheese();
        }

        System.out.println(time);

        br.close();
    }

    private static void meltCheese() {
        for (int i = 0; i < cheeseList.size(); i++) {
            int row = cheeseList.get(i)[0];
            int col = cheeseList.get(i)[1];
            int cnt = 0;

            // 치즈 기준 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];

                // 외부 공기를 접한 횟수 세기
                if (map[nr][nc] == 2) cnt++;
            }

            // 외부 공기와 2번 이상 접촉한 경우 치즈 녹음
            if (cnt >= 2) {
                map[row][col] = 0;
                cheeseCnt--;
                cheeseList.remove(i);
                i--;
            }
        }
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        map[row][col] = 2;  // 외부 공기라는 의미

        // 4방 탐색
        for (int dir = 0; dir < 4; dir++) {
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            // 범위를 벗어나면 스킵
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            // 이미 방문한적 있거나 치즈이면 스킵
            if (visited[nr][nc] || map[nr][nc] == 1) continue;

            // 다음 공기로 이동
            dfs(nr, nc);
        }
    }
}
