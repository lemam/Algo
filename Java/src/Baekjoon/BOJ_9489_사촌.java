package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9489_사촌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());   // 노드의 수
            int k = Integer.parseInt(st.nextToken());   // 사촌의 수를 구해야 하는 노드의 번호

            // n과 k가 0이면 마지막 줄이라는 뜻이므로 while문 종료
            if (n == 0 && k == 0) break;

            int[] nodes = new int[n];   // 입력 노드
            int[] parents = new int[n]; // i번째 노드의 부모 노드의 인덱스를 저장할 배열
            parents[0] = -1;    // 루트 노드의 부모는 없음

            int curParentIdx = -1;   // 현재 그룹의 부모 노드 인덱스
            int target = -1;    // k의 노드 번호

            st = new StringTokenizer(br.readLine());
            nodes[0] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < n; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());

                // k번 노드의 인덱스를 저장해둔다.
                if (nodes[i] == k) target = i;

                // 이전노드와의 차이가 1 이하이면 같은 그룹이므로, 현재 부모 인덱스를 넣는다.
                // 아니라면 서로 다른 그룹이므로, 다음 부모 인덱스를 넣는다.
                if (nodes[i] == nodes[i - 1] + 1) parents[i] = curParentIdx;
                else parents[i] = ++curParentIdx;
            }

            int answer = 0; // k의 사촌의 수

            // 모든 노드를 탐색하면서
            // k와 부모는 다르나 조부모가 같은 노드가 있는지 찾는다.
            for (int i = 1; i < n; i++) {
                if (parents[i] != parents[target] && parents[parents[i]] == parents[parents[target]]) {
                    answer++;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
