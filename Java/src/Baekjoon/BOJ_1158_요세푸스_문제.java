package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();

        // list 초기화
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");

        // 사람이 모두 제거될 때까지 반복
        while (!list.isEmpty()) {
            // K-1번째 사람까지는 리스트에서 제거한 후 다시 넣어서 뒤로 보낸다.
            for (int i = 0; i < K - 1; i++) {
                list.add(list.remove());
            }

            // K번째 사람은 리스트에서 제거한다.
            sb.append(list.remove());
            if (!list.isEmpty()) sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb);

        br.close();
    }
}
