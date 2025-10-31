package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_17073_나무_위의_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노드의 개수
        int W = Integer.parseInt(st.nextToken());   // 1번 노드에 고인 물의 양
        List<Integer>[] tree = new ArrayList[N + 1];

        // tree 초기화
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 간선 N-1개 입력
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        /*
         물이 움직이지 않을 때는 모든 물이 리프 노드로 내려갔을 때이다.
         또한 Pi가 0보다 큰 정점만 고려하면 되므로 모든 리프 노드의 기댓값의 평균을 구하면 된다.
         모든 리프노드의 기댓값은 1번 루트노드에 들어있던 w이므로, 평균은 `w / (리프노드의 개수)`이 된다.
         */

        int leafCnt = 0;  // 리프 노드의 개수

        // 리프 노드 개수 세기
        for (int i = 2; i <= N; i++) {
            if (tree[i].size() == 1) leafCnt++;
        }

        // 소수점 이하 10자리로 반올림 출력
        System.out.printf("%.10f", (double) W / leafCnt);

        br.close();
    }
}