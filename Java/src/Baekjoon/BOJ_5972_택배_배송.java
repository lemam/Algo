package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5972_택배_배송 {
    private static final int INF = Integer.MAX_VALUE;

    private static class Node implements Comparable<Node> {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 헛간(정점)의 개수
        int M = Integer.parseInt(st.nextToken());   // 길(간선)의 개수
        ArrayList<Node>[] graph = new ArrayList[N + 1]; // 그래프 배열
        int[] dist = new int[N + 1];    // 최소 비용 배열

        // 그래프 배열 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 최소 비용 배열 초기화
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }

        // 그래프의 간선 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());   // 시작 헛간
            int B = Integer.parseInt(st.nextToken());   // 도착 헛간
            int C = Integer.parseInt(st.nextToken());   // 소의 개수

            // 양방향 소의 길 연결
            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        // 다익스트라 알고리즘 수행
        boolean[] visited = new boolean[N + 1]; // 방문 배열
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 1번 헛간에서 시작
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            visited[curr.idx] = true;

            for (Node next : graph[curr.idx]) {
                // 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (!visited[next.idx] && dist[next.idx] > dist[curr.idx] + next.cost) {
                    dist[next.idx] = dist[curr.idx] + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        // N번 헛간까지의 최소 비용 출력
        System.out.println(dist[N]);

        br.close();
    }
}
