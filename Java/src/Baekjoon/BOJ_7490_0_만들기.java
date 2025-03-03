package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_7490_0_만들기 {
    private static final String[] op = {"+", "-", " "};
    private static List<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            result = new ArrayList<>();

            // 모든 수식 만들기
            dfs(1, "1", N);

            // ASCII 순서에 따라 정렬
            Collections.sort(result);

            // 출력
            for (String str : result) {
                sb.append(str).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int depth, String str, int N) {
        // 수식 계산하기
        if (depth == N) {
            String express = str.replace(" ", "");

            // 수식의 값이 0이면 수식을 result에 저장한다.
            if (calculate(express) == 0) {
                result.add(str);
            }

            return;
        }

        // 연산자 추가
        for (int i = 0; i < 3; i++) {
            dfs(depth + 1, str + op[i] + Integer.toString(depth + 1), N);
        }
    }

    private static int calculate(String express) {
        StringTokenizer st = new StringTokenizer(express, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("+"))
                sum += Integer.parseInt(st.nextToken());
            else
                sum -= Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
