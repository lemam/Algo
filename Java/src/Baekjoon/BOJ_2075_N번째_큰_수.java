package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2075_N번째_큰_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 표의 크기
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // PriorityQueue에 가장 큰 숫자들 순서대로 N개만 남도록 저장한다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
                if (pq.size() > N) pq.poll();   // pq의 길이가 N개를 넘을 경우, 최솟값을 없앤다.
            }
        }

        // pq에는 N번째 ~ 1번채 최댓값이 들어있으므로,
        // 가장 앞에 있는 수가 N번째 큰 수이다.
        System.out.println(pq.peek());

        br.close();
    }
}
