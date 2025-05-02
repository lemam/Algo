package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1976_여행_가자 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 도시의 수
        int M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시의 수
        parent = new int[N + 1];    // 도시 번호 1번부터 시작

        // parent 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 연결된 도시를 합집합 연산한다.
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int state = Integer.parseInt(st.nextToken());

                // 연결되어 있다면 i와 j를 같은 집합으로 묶는다.
                if (state == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));   // 시작 도시의 부모
        boolean canVisited = true;  // 여행 가능 여부

        // 여행 계획 확인
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken()); // 현재 도시

            if (start != find(now)) {
                canVisited = false;
                break;
            }
        }

        // 출력
        if (canVisited) System.out.println("YES");
        else System.out.println("NO");

        br.close();
    }

    // y의 부모를 x의 부모로 치환한다. (x > y 일 경우, 반대로 수행)
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    // x의 부모를 찾는다.
    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }
}
