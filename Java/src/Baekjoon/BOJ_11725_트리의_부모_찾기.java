package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11725_트리의_부모_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 노드의 개수
        List<Integer>[] tree = new ArrayList[N + 1];

        // tree 초기화
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        // 노드 입력
        StringTokenizer st = null;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // BFS로 부모 노드 찾기
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);   // 루트 노드부터 시작

        int[] parents = new int[N + 1]; // 각 노드의 부모 노드 번호를 저장하는 배열
        parents[1] = -1;    // 루트의 부모는 없으므로 -1로 표현

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : tree[curr]) {
                if (parents[next] == 0) {
                    parents[next] = curr;
                    queue.add(next);
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
