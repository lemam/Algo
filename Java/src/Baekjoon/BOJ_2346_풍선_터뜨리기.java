package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2346_풍선_터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        int[] arr = new int[N];

        // arr 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1번 풍선부터 시작
        sb.append("1 ");
        int num = arr[0];   // 터트린 풍선 안에 든 숫자

        // deque 초기화 (2번 풍선부터)
        for (int i = 1; i < N; i++) {
            deque.add(new int[]{i + 1, arr[i]});   // {풍선 idx, 내용}
        }

        while (!deque.isEmpty()) {
            // 양수인 경우
            if (num > 0) {
                // `num-1`번 순서 뒤로 넘기기
                for (int i = 0; i < num - 1; i++) {
                    deque.add(deque.poll());
                }

                // 다음 num번째 풍선 터트리기
                int[] next = deque.poll();
                num = next[1];
                sb.append(next[0]).append(" ");
            }
            // 음수인 경우
            else {
                // `num-1`번 순서 앞으로 넘기기
                for (int i = 0; i < -num - 1; i++) {
                    deque.addFirst(deque.pollLast());
                }

                // 다음 뒤에서 num번째 풍선 터트리기
                int[] next = deque.pollLast();
                num = next[1];
                sb.append(next[0]).append(" ");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
