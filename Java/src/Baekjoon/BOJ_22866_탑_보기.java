package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_22866_탑_보기 {
    private static class Building {
        int index, height;

        public Building(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 건물의 개수
        Stack<Building> stack = new Stack<>();
        Building[] arr = new Building[N + 1];       // 건물 높이 배열
        int[][] near = new int[N + 1][2];           // 각 건물의 가장 가까운 건물 정보를 저장하는 배열
        int[] count = new int[N + 1];               // 각 건물에서 보이는 건물의 개수를 저장하는 배열

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = new Building(i, Integer.parseInt(st.nextToken()));
            Arrays.fill(near[i], 100001);    // 가장 큰 차이가 10만이므로 100001로 초기화
        }

        // 1. 왼쪽에 보이는 건물을 센다.
        for (int i = 1; i <= N; i++) {
            // 자신보다 작거나 같은 건물은 보이지 않으므로 스택에서 꺼낸다.
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }

            // 남은 건물의 수를 저장
            count[i] += stack.size();

            // 보이는 건물 중 가장 가까운 건물이 있는지 확인한다.
            if (!stack.isEmpty()) {
                int gap = Math.abs(stack.peek().index - i); // 현재 건물과의 거리
                // 이전 기록보다 가까운 건물이라면 건물의 번호와 거리를 갱신한다.
                if (gap < near[i][1]) {
                    near[i][0] = stack.peek().index;
                    near[i][1] = gap;
                }
                // 이전 기록과 거리는 같지만, 건물 번호가 더 작을 경우 갱신한다.
                else if (gap == near[i][1] && stack.peek().index < near[i][0]) {
                    near[i][0] = stack.peek().index;
                }
            }

            stack.push(arr[i]);
        }

        stack.clear();

        // 2. 오른쪽에 보이는 건물을 센다.
        for (int i = N; i >= 1; i--) {
            // 자신보다 작거나 같은 건물은 보이지 않으므로 스택에서 꺼낸다.
            while (!stack.isEmpty() && stack.peek().height <= arr[i].height) {
                stack.pop();
            }

            // 남은 건물의 수를 저장
            count[i] += stack.size();

            // 보이는 건물 중 가장 가까운 건물이 있는지 확인한다.
            if (!stack.isEmpty()) {
                int gap = Math.abs(stack.peek().index - i);
                if (gap < near[i][1]) {
                    near[i][0] = stack.peek().index;
                    near[i][1] = gap;
                } else if (gap == near[i][1] && stack.peek().index < near[i][0]) {
                    near[i][0] = stack.peek().index;
                }
            }

            stack.push(arr[i]);
        }

        // 3. 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (count[i] == 0) {
                sb.append(0).append("\n");
            } else {
                // 보이는 건물 개수 + 가까운 건물 번호 출력
                sb.append(count[i]).append(" ").append(near[i][0]).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}