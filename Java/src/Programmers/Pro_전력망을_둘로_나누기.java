package Programmers;

import java.util.*;

class Pro_전력망을_둘로_나누기 {
    private ArrayList<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        // 1. 그래프 초기화
        graph = new ArrayList[n + 1];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 양방향 간선 추가
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 3. 모든 간선을 하나씩 제거하면서 그래프를 두 개의 그룹으로 분리
        for (int i = 0; i < wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            // 간선 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int count = dfs(1, new boolean[n + 1]);  // 한쪽 전력망의 송전탑의 개수
            int diff = Math.abs(count - (n - count));   // 두 전력망의 송전탑 개수 차이
            answer = Math.min(answer, diff);

            // 간선 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return answer;
    }

    private int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;

        // 인접한 노드 순회
        // 방문하지 않은 노드가 있으면 개수를 1 증가
        for (int next : graph[v]) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }

        return count;
    }
}