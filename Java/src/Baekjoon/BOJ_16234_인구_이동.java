package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16234_인구_이동 {
    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<int[]> unionList;

    // 12 3 6 9
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 땅의 크기
        L = Integer.parseInt(st.nextToken());   // 두 나라의 인구 차이 최소값
        R = Integer.parseInt(st.nextToken());   // 두 나라의 인구 차이 최대값
        map = new int[N][N];    // 땅 배열

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0; // 인구 이동한 기간

        // 더이상 인구 이동이 일어나지 않을 때까지 반복
        while (true) {
            boolean isMove = false; // 오늘 인구 이동 여부
            visited = new boolean[N][N];

            // 모든 좌표에서 BFS 탐색을 실행한다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문한 칸이면 스킵
                    if (visited[i][j]) continue;

                    // BFS 탐색으로 연합의 총 인구 수를 얻는다.
                    int sum = bfs(i, j);

                    // 연합이 이루는 칸의 수가 1개 초과인 경우
                    if (unionList.size() > 1) {
                        // 인구 수를 변경한다.
                        update(sum);
                        isMove = true;
                    }
                }
            }

            // 오늘 인구 이동이 일어나지 않았다면 반복을 멈춘다.
            if (!isMove) break;

            answer++;
        }

        System.out.println(answer);

        br.close();
    }

    private static void update(int sum) {
        int population = sum / unionList.size();    // 변경될 인구수

        // 연합의 모든 칸의 인구수를 변경한다.
        for (int[] coord : unionList) {
            map[coord[0]][coord[1]] = population;
        }
    }

    private static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        unionList = new ArrayList<>();  // 연합한 칸의 좌표를 저장할 리스트

        queue.add(new int[]{row, col});
        unionList.add(new int[]{row, col});
        visited[row][col] = true;

        int sum = map[row][col];    // 연합의 총 인구수

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];

                // 배열 범위 밖이거나 이미 방문한 칸이면 스킵
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;

                int diff = Math.abs(map[curr[0]][curr[1]] - map[nr][nc]);   // 두 땅의 인구 차

                // 두 땅의 인구 차가 L 이상 R 이하인 경우
                if (diff >= L && diff <= R) {
                    queue.add(new int[]{nr, nc});
                    unionList.add(new int[]{nr, nc});    // 연합에 추가
                    visited[nr][nc] = true;
                    sum += map[nr][nc]; // 인구수를 더한다.
                }
            }
        }

        return sum;
    }
}
