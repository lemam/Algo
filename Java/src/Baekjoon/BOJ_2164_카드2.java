package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 1번부터 N번까지의 카드 추가
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            // 제일 위에 있는 카드를 버린다.
            queue.poll();
            // 그 다음 제일 위에 있는 카드를 제일 아래로 옮긴다.
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());

        br.close();
    }
}