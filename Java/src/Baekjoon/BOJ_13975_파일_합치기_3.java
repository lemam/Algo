package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13975_파일_합치기_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());    // 장의 수
            PriorityQueue<Long> pq = new PriorityQueue<>();
            long answer = 0;

            st = new StringTokenizer(br.readLine());

            // 파일 크기 입력
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            // 가장 작은 수끼리 먼저 합친다.
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;

                answer += sum;
                pq.add(sum);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
