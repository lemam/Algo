package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수열의 길이
        int S = Integer.parseInt(st.nextToken());   // 부분합의 합 조건의 최소값
        int[] arr = new int[N + 1]; // 수열 배열
        int answer = Integer.MAX_VALUE; // 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이

        // arr 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;

        while (start <= N && end <= N) {
            // 합이 S 이상이면 answer를 갱신하고 start를 왼쪽으로 이동한다.
            if (sum >= S) {
                int len = end - start;
                answer = Math.min(answer, len);
                sum -= arr[start++];
            }
            // 합이 S 미만이면 end를 왼쪽으로 이동한다.
            else {
                sum += arr[end++];
            }
        }

        // 합을 만드는 것이 불가능하다면 0을 출력한다.
        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);

        br.close();
    }
}
