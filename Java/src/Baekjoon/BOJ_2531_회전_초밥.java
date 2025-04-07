package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2531_회전_초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 벨트 위 접시의 수
        int d = Integer.parseInt(st.nextToken());   // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        int[] belt = new int[N];    // 회전 초밥 벨트 배열
        int answer = 0; // 먹을 수 있는 초밥의 가짓수의 최댓값

        // belt 입력
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        // 모든 접시를 시작점으로 설정하고 탐색
        for (int i = 0; i < N; i++) {
            int count = 1;
            int[] visited = new int[d + 1];

            visited[c]++;

            // k개의 접시 연속으로 먹기
            for (int j = 0; j < k; j++) {
                int idx = (i + j) % N;

                if (visited[belt[idx]] == 0) count++;
                visited[belt[idx]]++;
            }

            // 종류 최댓값 갱신
            answer = Math.max(answer, count);
        }

        System.out.println(answer);

        br.close();
    }
}
