package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11779_최소비용_구하기_2 {
    private static class Node implements Comparable<Node> {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    private static ArrayList<Node>[] bus;
    private static int[] dist, route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // 도시의 개수
        int m = Integer.parseInt(br.readLine());    // 버스의 개수
        bus = new ArrayList[n + 1];

        // bus 초기화
        for (int i = 1; i <= n; i++) {
            bus[i] = new ArrayList<>();
        }

        // bus 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());   // 출발 도시
            int end = Integer.parseInt(st.nextToken());     // 도착 도시
            int cost = Integer.parseInt(st.nextToken());    // 비용

            bus[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());   // 출발점
        int end = Integer.parseInt(st.nextToken());     // 도착점

        // 다익스트라 수행
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, 100000001);

        dijkstra(start, end, n);

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");   // 최소 비용

        // end ~ start 까지의 최소 비용 이동 경로 가져오기
        List<Integer> path = new ArrayList<>();
        int currNode = end;

        while (currNode != 0) {
            path.add(currNode);
            currNode = route[currNode];
        }

        sb.append(path.size()).append("\n");   // 경로의 도시 개수

        // 경로 방문 순서
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dijkstra(int start, int end, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, end));

        boolean[] visited = new boolean[n + 1];

        dist[start] = 0;
        route[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.e]) continue;

            visited[curr.e] = true;

            for (Node next : bus[curr.e]) {
                if (dist[next.e] > dist[curr.e] + next.cost) {
                    dist[next.e] = dist[curr.e] + next.cost;
                    pq.add(new Node(next.e, dist[next.e]));
                    route[next.e] = curr.e; // 이전 경로 저장
                }
            }
        }
    }
}
