package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3584_가장_가까운_공통_조상 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());    // 노드의 수
            int[] parents = new int[N + 1];

            // 간선 입력
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());   // 부모
                int B = Integer.parseInt(st.nextToken());   // 자식

                parents[B] = A; // B의 부모는 A
            }

            // 가장 가까운 공통 조상을 구할 두 노드
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            visited[node1] = true;

            // node1부터 루트까지 방문 체크하기
            while (parents[node1] != 0) {
                node1 = parents[node1];
                visited[node1] = true;
            }

            // node1이 방문한 곳이 아닐 때까지 부모를 타고 올라가기
            while (!visited[node2]) {
                node2 = parents[node2];
            }

            // node1, node2가 서로 처음 만나는 곳이 공통 조상
            sb.append(node2).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
