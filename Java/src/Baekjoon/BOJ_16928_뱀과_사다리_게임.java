package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16928_뱀과_사다리_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사다리의 수
        int M = Integer.parseInt(st.nextToken());   // 뱀의 수
        int[] board = new int[101]; // 보드판 배열

        // 보드판 배열 초기화
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        // 사다리 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 사다리 시작 칸
            int y = Integer.parseInt(st.nextToken());   // 사다리 도착 칸

            board[x] = y;   // x번 칸에 도착하면 y번 칸으로 이동한다.
        }

        // 뱀 정보 입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 뱀 시작 칸
            int v = Integer.parseInt(st.nextToken());   // 뱀 도착 칸

            board[u] = v;   // u번 칸에 도착하면 v번 칸으로 이동한다.
        }

        System.out.println(playGame(board));

        br.close();
    }

    // BFS
    private static int playGame(int[] board) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[101];   // 주사위 횟수를 저장할 배열

        queue.add(1);   // 1번부터 시작
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // 주사위가 1 ~ 6이 나오는 경우 탐색
            for (int i = 1; i <= 6; i++) {
                int next = curr + i;

                // 범위 밖이거나 이미 방문한 적이 있는 곳이면 건너 뛰기
                if (next > 100 || visited[board[next]] > 0)
                    continue;

                // 다음 위치를 큐에 넣고, 주사위 횟수를 저장한다.
                queue.add(board[next]);
                visited[board[next]] = visited[curr] + 1;

                // 100번 칸에 도착하면 게임을 종료한다.
                if (board[next] == 100)
                    break;
            }
        }

        return visited[100];
    }
}