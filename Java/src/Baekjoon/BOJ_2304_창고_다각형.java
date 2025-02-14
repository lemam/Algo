package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2304_창고_다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 기둥의 개수
        int[] arr = new int[1001];  // 기둥 위치를 저장할 배열
        int start = Integer.MAX_VALUE;  // 기둥 시작 지점
        int end = 0;                    // 기둥 끝 지점

        // 기둥 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());   // 기둥 위치
            int H = Integer.parseInt(st.nextToken());   // 기둥 높이

            arr[L] = H;
            start = Math.min(L, start);
            end = Math.max(L, end);
        }

        Stack<Integer> stack = new Stack<>();

        // 왼쪽 비교
        int height = arr[start];  // 첫 기둥의 높이

        for (int i = start + 1; i <= end; i++) {
            // 현재 기둥의 높이가 height보다 작으면
            // 현재 기둥의 위치를 스택에 넣는다.
            if (arr[i] < height) {
                stack.push(i);
            }
            // 아니라면 지금까지 저장된 모든 위치의 값을 height를 적용한다.
            else {
                while (!stack.isEmpty()) {
                    arr[stack.pop()] = height;
                }
                height = arr[i];    // 현재 기둥 높이로 height 갱신
            }
        }

        stack.clear();

        // 오른쪽 비교
        height = arr[end];   // 마지막 기둥의 높이

        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < height) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    arr[stack.pop()] = height;
                }
                height = arr[i];
            }
        }

        int answer = 0; // 창고의 넓이

        for (int i = start; i <= end; i++) {
            answer += arr[i];
        }

        System.out.println(answer);

        br.close();
    }
}
