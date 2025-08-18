package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14938_서강그라운드 {
    private static class Node implements Comparable<Node> {
        int num, cost;

        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    private static int n, m;
    private static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 지역의 개수
        m = Integer.parseInt(st.nextToken());   // 수색범위
        int r = Integer.parseInt(st.nextToken());   // 길의 개수

        // items 입력
        st = new StringTokenizer(br.readLine());
        items = new int[n + 1];   // i번 지역의 아이템 개수 배열

        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Node>[] graph = new ArrayList[n + 1];

        // graph 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph 입력
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // 시작 지역
            int b = Integer.parseInt(st.nextToken());   // 도착 지역
            int l = Integer.parseInt(st.nextToken());   // 길의 길이

            // 양방향
            graph[a].add(new Node(b, l));
            graph[b].add(new Node(a, l));
        }

        int answer = 0; // 최대 아이템 개수

        // 모든 노드를 시작점으로 하여 다익스트라 수행
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dijkstra(i, graph));
        }

        System.out.println(answer);

        br.close();
    }

    private static int dijkstra(int start, ArrayList<Node>[] graph) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        // 다익스트라 수행
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int num = curr.num;

            if (visited[num]) continue;

            visited[num] = true;

            for (Node next : graph[num]) {
                if (!visited[next.num] && dist[next.num] > dist[num] + next.cost) {
                    dist[next.num] = dist[num] + next.cost;
                    pq.add(new Node(next.num, dist[next.num]));
                }
            }
        }

        // 수색 범위 내로 갈 수 있는 모든 지역의 아이템 개수 합하기
        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                result += items[i];
            }
        }

        return result;
    }
}
