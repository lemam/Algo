package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_11279_최대_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) pq.add(x);
            else {
                int output = pq.isEmpty() ? 0 : pq.poll();
                sb.append(output).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
