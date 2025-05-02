package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1238_파티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 학생의 수
        int M = Integer.parseInt(st.nextToken());   // 도로의 수
        int X = Integer.parseInt(st.nextToken());   // 파티가 열리는 마을 번호
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        ArrayList<ArrayList<int[]>> reverseGraph = new ArrayList<>();

        // graph 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 단방향 도로 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, time});
            reverseGraph.get(end).add(new int[]{start, time});
        }

        int[] dist1 = dijkstra(graph, X, N);            // X에서 집으로 돌아갈 때 최단 거리
        int[] dist2 = dijkstra(reverseGraph, X, N);     // 집에서 X로 갈 때 최단 거리
        int answer = 0;

        // 왕복 거리 최대값 저장
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dist1[i] + dist2[i]);
        }

        System.out.println(answer);

        br.close();
    }

    private static int[] dijkstra(ArrayList<ArrayList<int[]>> graph, int start, int N) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        pq.add(new int[]{start, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];

            if (!visited[node]) {
                visited[node] = true;

                for (int[] next : graph.get(node)) {
                    if (!visited[next[0]] && dist[next[0]] > dist[node] + next[1]) {
                        dist[next[0]] = dist[node] + next[1];
                        pq.add(new int[]{next[0], dist[next[0]]});
                    }
                }
            }
        }

        return dist;
    }
}
