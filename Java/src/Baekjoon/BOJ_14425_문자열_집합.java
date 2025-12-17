package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14425_문자열_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    //  문자열의 개수
        int M = Integer.parseInt(st.nextToken());    //  입력 개수

        Set<String> set = new HashSet<>();
        int answer = 0;    // 집합 S에 포함되어 있는 문자열의 개수

        // 집합 S의 문자열 입력
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // M개의 문자열 검사
        for (int i = 0; i < M; i++) {
            // set에 문자열이 포함되어 있으면 개수를 센다.
            if (set.contains(br.readLine()))
                answer++;
        }

        System.out.println(answer);

        br.close();
    }
}