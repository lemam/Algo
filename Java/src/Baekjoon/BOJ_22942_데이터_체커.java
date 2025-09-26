package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_22942_데이터_체커 {
    private static boolean flag = false;    // 겹침 여부 판별

    private static class Point implements Comparable<Point> {
        int circleIdx, x;   // 원의 인덱스, x좌표

        public Point(int circleIdx, int x) {
            this.circleIdx = circleIdx;
            this.x = x;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) flag = true; // 두 좌표값이 같다면 겹치는 원이므로 flag를 갱신한다.
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 원의 개수
        PriorityQueue<Point> pq = new PriorityQueue<>();    // 원의 오른쪽, 왼쪽 끝점 좌표값을 넣을 우선순위 큐, x좌표 오름차순 정렬
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   // 원의 중심 x좌표
            int r = Integer.parseInt(st.nextToken());   // 원의 반지름

            // 원의 왼쪽, 오른쪽 끝점 좌표를 pq에 저장한다.
            pq.add(new Point(i, x - r));
            pq.add(new Point(i, x + r));
        }

        // 정렬 중 겹치는 원을 발견한 경우
        if (flag) {
            System.out.println("NO");
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // '올바른 괄호' 문제처럼 생각하면 된다.
        while (!pq.isEmpty()) {
            // 왼쪽 좌표부터 순서대로 스택에 push한다.
            if (stack.isEmpty()) {
                stack.push(pq.poll().circleIdx);
            } else {
                int idx = pq.poll().circleIdx;

                // 스택의 가장의 위에 있는 좌표값이 현재 좌표값과 같은 원 인덱스에 속해있으면 stack에서 pop 한다.
                // 아니라면 스택에 push한다.
                if (stack.peek() == idx) stack.pop();
                else stack.push(idx);
            }
        }

        // 스택이 비어있다면 모든 원이 겹치지 않았다는 뜻
        if (stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
