package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1863_스카이라인_쉬운거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 스카이라인 개수
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // 스카인라인 좌표 탐색
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 스택이 비지 않았고, 가장 마지막에 들어온 값이 y보다 크면
            // 건물의 높이가 낮아졌다는 것으로 이는 뒤에 있는 높은 건물이 끝났다는 뜻이다.
            // => 현재 빌딩과 같은 높이가 나올 때까지 건물을 개수를 센다.
            while (!stack.isEmpty() && stack.peek() > y) {
                answer++;
                stack.pop();    // 개수를 센 건물은 제거
            }

            // 스택이 비지 않았고, 가장 마지막에 들어온 값과 y와 같다면
            // 같은 건물을 뜻하므로 스킵한다.
            if (!stack.isEmpty() && stack.peek() == y) continue;

            // 현재 x 좌표의 건물 중 최고 높이로 stack을 갱신해준다.
            stack.push(y);
        }

        // 모든 좌표 탐색 후 스택이 비어있지 않은 경우
        while (!stack.isEmpty()) {
            // 남아있는 건물들의 개수를 센다.
            if (stack.peek() > 0) answer++;
            stack.pop();
        }

        System.out.println(answer);

        br.close();
    }
}
