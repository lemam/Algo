package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1504_특정한_최단_경로 {
    private static class Node implements Comparable<Node> {
        int e, dist;

        public Node(int e, int dist) {
            this.e = e;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    private static final int INF = 200000 * 1000;
    private static int N;
    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        graph = new ArrayList[N + 1];

        // graph 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 정점 1
            int b = Integer.parseInt(st.nextToken());   // 정점 2
            int c = Integer.parseInt(st.nextToken());   // 거리

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 두 개의 정점 번호
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        int answer = INF;

        // 경로가 없는 경우
        if (result1 >= INF && result2 >= INF) {
            answer = -1;
        }
        // 경로가 있을 경우 더 작은 값
        else {
            answer = Math.min(result1, result2);
        }

        System.out.println(answer);

        br.close();
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 이미 방문한 정점이면 스킵
            if (visited[curr.e]) continue;

            visited[curr.e] = true;

            // 연결된 모든 정점 탐색
            for (Node next : graph[curr.e]) {
                // 지금까지 계산한 next까지의 거리보다 curr을 경유해서 가는 거리가 더 짧을 경우 dist 갱신
                if (dist[next.e] > dist[curr.e] + next.dist) {
                    dist[next.e] = dist[curr.e] + next.dist;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist[end];
    }
}