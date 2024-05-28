package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085_사탕_게임 {
    private static int N, answer;
    private static char[][] map;

    // 3 6
    private static int[] dr = {0, 1};
    private static int[] dc = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        answer = 0;

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        solution();

        System.out.println(answer);

        br.readLine();
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char curr = map[i][j];

                // 오른쪽, 아래 방향 탐색
                for (int dir = 0; dir < 2; dir++) {
                    int nr = i + dr[dir];
                    int nc = j + dc[dir];

                    // 범위를 벗어나거나 현재 사탕의 색상과 같으면 건너뛴다.
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == curr) {
                        break;
                    }

                    // 사탕 교환
                    map[i][j] = map[nr][nc];
                    map[nr][nc] = curr;

                    // 가장 긴 행/열 길이 확인
                    search(map);

                    // 다시 원복
                    map[nr][nc] = map[i][j];
                    map[i][j] = curr;
                }
            }
        }
    }

    private static void search(char[][] map) {
        // 행에서 가장 긴 수열 찾기
        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }

            answer = Math.max(answer, count);
        }

        // 열에서 가장 긴 수열 찾기
        for (int j = 0; j < N; j++) {
            int count = 1;

            for (int i = 0; i < N - 1; i++) {
                if (map[i][j] == map[i + 1][j]) {
                    count++;
                } else {
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }

            answer = Math.max(answer, count);
        }
    }
}
