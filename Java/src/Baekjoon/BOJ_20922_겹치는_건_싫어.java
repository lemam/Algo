package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20922_겹치는_건_싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 정수의 개수
        int K = Integer.parseInt(st.nextToken());   // 허용하는 같은 원소의 최소 개수
        int[] arr = new int[N];                     // 수열
        int[] count = new int[100001];              // 원소의 개수를 저장할 배열
        int answer = 0;

        // arr 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투포인터
        int start = 0;
        int end = 0;

        // end가 배열 끝에 도달할 때까지 탐색
        while (end < arr.length) {
            // 1. end 이동하기
            // end가 한 칸씩 움직이면서 원소의 개수를 count 배열에 저장한다.
            // end가 배열 끝에 도달하거나 같은 원소의 개수가 K개 초과할 때까지 이동한다.
            while (end < arr.length && count[arr[end]] + 1 <= K) {
                count[arr[end]]++;
                end++;
            }

            // 부분 수열의 길이를 구한다.
            int result = end - start;
            answer = Math.max(answer, result);  // answer를 최댓값으로 갱신

            // start를 한 칸 이동하고, start였던 원소의 개수를 하나 빼준다.
            count[arr[start]]--;
            start++;
        }

        System.out.println(answer);

        br.close();
    }
}
