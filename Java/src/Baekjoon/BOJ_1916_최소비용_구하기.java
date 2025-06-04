package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1916_최소비용_구하기 {
    private static int N;
    private static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 도시의 개수
        int M = Integer.parseInt(br.readLine());    // 버스의 개수
        graph = new ArrayList[N + 1];

        // grpah 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());   // 출발
            int end = Integer.parseInt(st.nextToken());     // 도착
            int cost = Integer.parseInt(st.nextToken());    // 비용

            graph[start].add(new int[]{end, cost}); // 단방향 간선
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());   // 출발 도시 번호
        int end = Integer.parseInt(st.nextToken());     // 도착 도시 번호

        // start ~ end 까지 가는데 드는 최소 비용
        // 다익스트라 수행
        int answer = dijkstra(start, end);

        System.out.println(answer);

        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int[] cost = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        // 초기화
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (visited[curr[0]]) continue;

            visited[curr[0]] = true;

            // 연결된 간선 탐색
            for (int[] next : graph[curr[0]]) {
                // 방문하지 않았고, next로 이동한 비용이 기록된 비용보다 작은 경우
                if (!visited[next[0]] && cost[next[0]] > curr[1] + next[1]) {
                    cost[next[0]] = curr[1] + next[1];
                    pq.add(new int[]{next[0], cost[next[0]]});
                }
            }
        }

        return cost[end];
    }
}
