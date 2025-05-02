package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13144_List_of_Unique_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 수열의 길이
        int[] arr = new int[N]; // 수열 배열
        boolean[] visited = new boolean[100001];
        long answer = 0;

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터
        int start = 0;
        int end = 0;

        // 왼쪽부터 순서대로 탐색 시작
        for (start = 0; start < N; start++) {
            // 오른쪽 포인터 이동
            while (end < N) {
                if (visited[arr[end]]) break;   // 중복인 수이면 중단
                visited[arr[end]] = true;
                end++;
            }

            // start 위치에서 중복된 수 없이 만들 수 있는 부분 수열의 개수 = end - start
            answer += end - start;

            // 왼쪽 포인터 이동 전 현재 값의 방문 표시 제거
            visited[arr[start]] = false;
        }

        System.out.println(answer);

        br.close();
    }
}
