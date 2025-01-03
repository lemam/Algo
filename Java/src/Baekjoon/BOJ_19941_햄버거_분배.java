package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_19941_햄버거_분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 식탁의 길이
        int K = Integer.parseInt(st.nextToken());   // 햄버거를 선택할 수 있는 거리
        char[] table = br.readLine().toCharArray();   // 식탁
        int answer = 0; // 햄버거를 먹은 사람의 수

        for (int i = 0; i < N; i++) {
            // 현재 위치가 햄버거이거나 빈 칸이면 스킵한다.
            if (table[i] == 'H' || table[i] == 'X') continue;

            // 사람인 경우 -K ~ K까지의 범위를 왼쪽부터 탐색한다.
            for (int j = i - K; j <= i + K; j++) {
                // 식탁 범위 밖이면 스킵한다.
                if (j < 0 || j >= table.length) continue;

                // 햄버거가 있는 경우 먹은 수를 저장하고 탐색을 종료한다.
                if (table[j] == 'H') {
                    table[j] = 'X';
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}