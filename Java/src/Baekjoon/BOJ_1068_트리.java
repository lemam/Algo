package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1068_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[N];

        // graph 초기화
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;   // 루트 노드 번호

        // 그래프 입력하기
        for (int i = 0; i < N; i++) {
            // i번 노드의 부모 노드
            int p = Integer.parseInt(st.nextToken());

            if (p == -1) root = i;
            else graph[p].add(i);
        }

        // 지울 노드 번호
        int remove = Integer.parseInt(br.readLine());

        // 지울 노드가 루트 노드이면 트리 전체를 삭제하므로 정답은 0
        if (remove == root) {
            System.out.println(0);
            return;
        }

        // 삭제할 노드는 무시하고 나머지 리프 노드 탐색하기
        System.out.println(countLeafNode(root, remove, graph));

        br.close();
    }

    private static int countLeafNode(int idx, int remove, List<Integer>[] graph) {
        // 현재 노드에 삭제할 노드가 포함되어 있으면 삭제한다.
        if (graph[idx].contains(remove)) {
            graph[idx].remove(Integer.valueOf(remove));
        }

        int count = 0;

        // 현재 노드가 리프 노드이면 1을 리턴한다.
        if (graph[idx].isEmpty()) return 1;

        // 모든 연결 노드 탐색
        for (int node : graph[idx]) {
            count += countLeafNode(node, remove, graph);
        }

        return count;
    }
}
