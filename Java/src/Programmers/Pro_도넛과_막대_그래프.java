package Programmers;

import java.util.*;

class Pro_도넛과_막대_그래프 {
    public int[] solution(int[][] edges) {
        Map<Integer, Integer> out = new HashMap<>();    // 각 노드의 나가는 간선 수 저장
        Map<Integer, Integer> in = new HashMap<>();    // 각 노드의 들어오는 간선 수 저장
        int[] answer = new int[4];  // 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수

        // 1. 각 노드의 나가는, 들어오는 간선 개수 저장
        for (int[] edge : edges) {
            // 나가는 간선 저장
            out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            // 들어오는 간선 저장
            in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
        }

        // 2. 8자 그래프
        // 핵심 노드: 8자의 가운데 노드
        // 들어오는 간선과 나가는 간선이 2개 이상인 노드가 있음

        // 3. 생성한 정점
        // 나가는 간선이 2개 이상이고, 들어오는 간선이 없음
        for (int key : out.keySet()) {
            if (out.get(key) >= 2) {
                if (in.getOrDefault(key, 0) >= 2) {
                    answer[3]++;    // 8자 그래프
                } else {
                    answer[0] = key;    // 생성한 정점
                }
            }
        }

        // 4. 막대 그래프
        // 핵심 노드: 리프 노드
        // 들어오는 간선은 있으나, 나가는 간선이 없음
        for (int key : in.keySet()) {
            if (in.get(key) > 0) {
                if (!out.containsKey(key)) {
                    answer[2]++;
                }
            }
        }

        // 5. 도넛 그래프
        // 새로 생성된 정점의 간선의 수는 전체 그래프의 개수와 동일하다.
        // 도넛 그래프의 개수 = 전체 그래프 수 - 막대 그래프 수 - 8자 그래프 수
        answer[1] = out.get(answer[0]) - answer[2] - answer[3];

        return answer;
    }
}
