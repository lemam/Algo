package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2812_크게_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 자릿수
        int K = Integer.parseInt(st.nextToken());   // 지울 수 있는 횟수
        char[] input = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        for (char num : input) {
            // K 횟수가 아직 남아있고,
            // 덱의 마지막 숫자가 현재 숫자보다 작으면 삭제
            while (!deque.isEmpty() && K > 0 && deque.getLast() < num) {
                deque.removeLast();
                K--;
            }

            // 덱 뒤로 숫자를 넣는다.
            deque.addLast(num);
        }

        StringBuilder sb = new StringBuilder();

        // K 횟수가 남아있는 경우를 생각하여
        // 그 크기만큼만 출력한다. (dq.size() - K)
        while (deque.size() > K) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);

        br.close();
    }
}
