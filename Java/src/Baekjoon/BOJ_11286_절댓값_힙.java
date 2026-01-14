package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 연산의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
            // 절댓값이 작은 순으로 정렬
            // 같은 값이면 원본 값이 작은 순으로 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = Math.abs(o1) - Math.abs(o2);
                if (diff == 0) return o1 - o2;
                return diff;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            // 1. 0이 아니라면 배열에 x 값 넣기
            if (x != 0) {
                pq.add(x);
            }
            // 2. 0이면 절댓값이 가장 작은 값 출력하고 배열에서 제거하기
            // 배열이 비어있으면 0 출력하기
            else {
                int result = pq.isEmpty() ? 0 : pq.poll();
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}