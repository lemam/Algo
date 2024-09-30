package Programmers;

import java.util.*;

class Pro_가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        int answer = 0;

        // 인접 리스트 초기화
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 간선 저장
        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();    // 거리 별 노드의 개수

            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                for (int next : graph[now]) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }

            answer = size;
        }

        return answer;
    }
}
