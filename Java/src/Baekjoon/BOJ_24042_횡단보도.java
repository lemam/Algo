package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_24042_횡단보도 {
    private static class Edge {
        int node, signalTime;   // 도착 노드, 불이 들어오는 시간

        public Edge(int node, int signalTime) {
            this.node = node;
            this.signalTime = signalTime;
        }
    }

    private static class Node implements Comparable<Node> {
        int idx;
        long time;  // 생성 시간

        public Node(int idx, long time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 지역의 수
        int M = Integer.parseInt(st.nextToken());   // 횡단보도 주기

        List<Edge>[] graph = new ArrayList[N + 1];  // 인접 그래프

        // graph 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, i));
            graph[b].add(new Edge(a, i));
        }

        // 다익스트라
        long answer = dijkstra(graph, N, M);

        // 출력
        System.out.println(answer);

        br.close();
    }

    private static long dijkstra(List<Edge>[] graph, int N, int M) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        long[] dist = new long[N + 1];  // 최단 시간

        // 초기화
        pq.add(new Node(1, 0));

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        // 다익스트라 수행
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 기록된 최단 시간이 현재 시간보다 빠르다면 스킵
            if (dist[curr.idx] < curr.time) continue;

            // 연결된 간선 순회
            for (Edge edge : graph[curr.idx]) {
                // 다음 노드로 가기 위한 횡단보도 대기시간
                long waitTime = ((edge.signalTime - curr.time % M) + M) % M;
                // 다음 노드로 이동하는 시간
                long nextTime = curr.time + waitTime + 1;

                // nextTime이 최단 시간이라면 갱신하고 pq에 넣는다.
                if (dist[edge.node] > nextTime) {
                    dist[edge.node] = nextTime;
                    pq.add(new Node(edge.node, nextTime));
                }
            }
        }

        // N까지의 최단 시간 반환
        return dist[N];
    }
}
