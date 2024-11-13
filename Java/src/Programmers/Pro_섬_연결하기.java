package Programmers;

import java.util.*;

class Pro_섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int[] parent = new int[n];  // 각 섬들의 부모 섬 인덱스 배열
        int answer = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 다리를 비용을 기준으로 오름차순으로 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < costs.length; i++) {
            // 서로 부모가 다르면 다리를 잇는다.
            if (find(parent, costs[i][0]) != find(parent, costs[i][1])) {
                answer += costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }

    private void union(int[] parent, int node1, int node2) {
        int p1 = find(parent, node1);
        int p2 = find(parent, node2);

        if (p1 < p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) return node;
        return find(parent, parent[node]);
    }
}
