package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1446_지름길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 지름길의 개수
        int D = Integer.parseInt(st.nextToken());   // 고속도로의 길이
        List<List<int[]>> graph = new ArrayList<>();

        // graph 초기화
        for (int i = 0; i <= D; i++) {
            graph.add(new ArrayList<>());
        }

        // arr 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 시작
            int v = Integer.parseInt(st.nextToken());   // 도착
            int w = Integer.parseInt(st.nextToken());   // 가중치

            if (v <= D) // 노드 범위 이상일 경우 추가하지 않는다.
                graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[D + 1];    // 가중치를 기록할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;    // 시작 위치는 0

        // int[] a 중에서 두번째 요소인 a[1]를 기준으로 큐를 정렬한다.
        // 즉, 가중치(거리)를 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});   // {현재 위치, 현재 비용}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currPos = curr[0];
            int currDist = curr[1];


            // 현재 비용이 기록된 비용보다 크다면 무시한다.
            if (currDist > dist[currPos]) continue;

            // 1. 한 칸 이동
            // 한 칸 앞으로 이동한 위치가 도로 범위를 넘지 않고,
            // 한 칸 앞으로 이동한 비용이 기존 기록된 다음 칸 비용보다 작은 경우
            if (currPos + 1 <= D && currDist + 1 < dist[currPos + 1]) {
                // 다음 위치의 이동 거리를 갱신하고 큐에 추가한다.
                dist[currPos + 1] = currDist + 1;
                pq.add(new int[]{currPos + 1, currDist + 1});
            }

            // 2. 지름길로 이동
            // 현재 위치와 연결된 모든 지름길 탐색
            for (int[] node : graph.get(currPos)) {
                int nextPos = node[0];  // 지름길 도착 위치
                int nextDist = currDist + node[1];  // 지름길을 이용했을 때의 운전 거리

                // 지름길을 이용한 비용이 더 적다면 비용을 갱신한다.
                if (nextDist < dist[nextPos]) {
                    dist[nextPos] = nextDist;
                    pq.add(new int[]{nextPos, nextDist});
                }
            }
        }

        System.out.println(dist[D]);

        br.close();
    }
}
