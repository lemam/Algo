package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1927_최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());    // 연산의 개수

        // 연산 수행
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());    // 연산의 정보

            // 1. x가 자연수인 경우, 배열에 x를 추가
            if (x > 0) {
                pq.add(x);
            }
            // 2. x가 0인 경우, 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거
            else {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
