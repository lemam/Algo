package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_19637_IF문_좀_대신_써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());   // 칭호의 개수
        int M = Integer.parseInt(st.nextToken());   // 캐릭터들의 개수
        String[][] titles = new String[N][2];  // 칭호 배열 [이름, 상한값]

        // 칭호 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i][0] = st.nextToken();  // 칭호 이름
            titles[i][1] = st.nextToken();  // 전투력 상한값
        }

        // 캐릭터 칭호 확인
        for (int i = 0; i < M; i++) {
            int attack = Integer.parseInt(br.readLine());   // 캐릭터의 공격력

            // 이분 탐색
            int left = 0;
            int right = N - 1;
            String key = titles[0][0];

            while (left <= right) {
                int mid = (left + right) / 2;
                int midValue = Integer.parseInt(titles[mid][1]);

                if (attack > midValue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                    key = titles[mid][0];
                }
            }

            sb.append(key).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}