package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13549_숨바꼭질_3 {
    private static final int SIZE = 100001;
    private static final int INF = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수빈이의 위치
        int K = Integer.parseInt(st.nextToken());   // 동생의 위치

        int answer = dijkstra(N, K);

        System.out.println(answer);

        br.close();
    }

    private static int dijkstra(int start, int end) {
        // [목적지, 비용]
        // 비용을 기준으로 오름차순 정렬된 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        boolean[] visited = new boolean[SIZE];  // 방문 배열
        int[] cost = new int[SIZE]; // 비용 배열

        // 비용 배열을 최댓값(무한)으로 설정한다.
        Arrays.fill(cost, INF);

        // 시작 위치 설정
        cost[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            // 동생이 있는 위치에 도착하면 종료한다.
            if (curr[0] == end) break;

            // 이미 방문한 위치이면 건너뛴다.
            if (visited[curr[0]]) continue;

            // 방문 처리
            visited[curr[0]] = true;

            // 1. X-1로 이동할 경우
            int nx = curr[0] - 1;

            // 다음 이동 위치가 범위 안이고,
            if (nx >= 0) {
                // 다음 이동까지의 최소 비용보다 현재 이동 비용이 더 작으면 이동한다.
                if (cost[nx] > cost[curr[0]] + 1) {
                    cost[nx] = cost[curr[0]] + 1;
                    pq.add(new int[]{nx, cost[nx]});
                }
            }

            // 2. X+1로 이동할 경우
            nx = curr[0] + 1;

            if (nx < SIZE) {
                if (cost[nx] > cost[curr[0]] + 1) {
                    cost[nx] = cost[curr[0]] + 1;
                    pq.add(new int[]{nx, cost[nx]});
                }
            }

            // 3. X*2로 이동할 경우
            nx = curr[0] * 2;

            if (nx < SIZE) {
                // 순간이동은 0초이므로 추가 비용이 없다.
                if (cost[nx] > cost[curr[0]]) {
                    cost[nx] = cost[curr[0]];
                    pq.add(new int[]{nx, cost[nx]});
                }
            }
        }

        return cost[end];
    }
}
