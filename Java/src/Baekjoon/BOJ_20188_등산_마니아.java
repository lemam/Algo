package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20188_등산_마니아 {
    private static List<Integer>[] tree;
    private static int[] subTree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // 오두막(정점)의 개수

        // tree 초기화
        tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        // subTree 초기화
        subTree = new int[N + 1]; // i번째 노드를 루트 노드로 하는 서브 트리의 정점의 개수를 저장
        for (int i = 0; i < N + 1; i++) {
            subTree[i] = 1; // 자기 자신 포함
        }

        // 오솔길(간선) 입력
        StringTokenizer st = null;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        // visited 초기화
        visited = new boolean[N + 1];
        visited[1] = true;
        dfs(1); // 루트 노드부터 DFS 탐색

        long variety = 0;   // 모든 경로의 다양성의 총 합

        // 모든 간선을 순회
        // 2번 노드에서 위로 뻗어 나가는(부모로 향하는) 간선부터
        // 마지막 노드에서 위로 뻗어나가는 간선까지 순회하면 모든 간선을 고려하게 된다.
        for (int i = 2; i <= N; i++) {
            int restNodeCnt = N - subTree[i];   // 현재 선택한 간선을 사용하지 않는 조합을 이루는 노드의 개수
            variety += nC2(N) - nC2(restNodeCnt);   // 경로를 만들 때 `현재 간선을 사용하는 경우 - 사용하지 않는 경우`
        }

        System.out.println(variety);

        br.close();
    }

    // n^2가 int를 초과할 수 있으므로 long을 사용한다.
    private static long nC2(int n) {
        return (long) n * (n - 1) / 2;
    }

    // DFS로 루트 노드부터 리프 노드까지 내려가며 subTree 배열의 값을 채운다.
    private static int dfs(int idx) {
        for (int next : tree[idx]) {
            if (visited[next]) continue;
            visited[next] = true;
            subTree[idx] += dfs(next);  // idx를 루트로 하는 서브 트리의 노드 개수 세기
        }

        return subTree[idx];
    }
}
