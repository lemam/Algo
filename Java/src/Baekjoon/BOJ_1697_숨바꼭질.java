package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1697_숨바꼭질 {
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        visited = new int[100001]; // 각 위치(점)를 방문한 시간(초)

        // 이동 시간 계산
        System.out.println(bfs(N, K));

        br.close();
    }

    private static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int curr = queue.poll(); // 현재 위치

            // 현재 위치가 동생의 위치이면 중단한다.
            if (curr == k)
                return visited[curr]; // 0초를 1로 표현했으므로 -1을 한다.

            // x-1로 이동
            if (curr - 1 >= 0 && visited[curr - 1] == 0) {
                visited[curr - 1] = visited[curr] + 1;
                queue.add(curr - 1);
            }

            // x+1로 이동
            if (curr + 1 <= 100000 && visited[curr + 1] == 0) {
                visited[curr + 1] = visited[curr] + 1;
                queue.add(curr + 1);
            }

            // x*2로 이동
            if (curr * 2 <= 100000 && visited[curr * 2] == 0) {
                visited[curr * 2] = visited[curr] + 1;
                queue.add(curr * 2);
            }
        }

        return -1;
    }
}