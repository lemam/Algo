package Programmers;

import java.util.*;

public class Pro_네트워크 {
    private List<Integer>[] graph;
    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        int answer = 0;

        // 인접 리스트 초기화
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 정보 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) graph[i].add(j);
            }
        }

        // 연결된 네트워크 개수 확인하기
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i);
            answer++;
        }

        return answer;
    }

    private void dfs(int idx) {
        visited[idx] = true;

        for (int node : graph[idx]) {
            if (!visited[node]) dfs(node);
        }
    }
}
