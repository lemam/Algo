package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1138_한_줄로_서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 사람의 수
        int[] arr = new int[N + 1];                 // index: 키, value: 왼쪽에 있는 사람 수
        int[] result = new int[N + 1];              // 줄 배열

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 줄 세우기
        for (int hIdx = 1; hIdx <= N; hIdx++) {
            int count = 0;  // 빈칸의 개수

            // 1번 줄부터 빈칸의 개수를 센다.
            for (int i = 1; i <= N; i++) {
                if (result[i] != 0) continue;   // 빈칸이 아닌 경우 스킵한다.

                // 왼쪽에 있는 사람의 수와 빈칸의 개수가 같으면 줄을 세운다.
                if (arr[hIdx] == count) {
                    result[i] = hIdx;
                    break;
                }

                count++;    // 빈칸 카운트
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
