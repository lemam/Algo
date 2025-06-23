package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_15666_N과_M_12 {
    private static int N, M;
    private static int[] numbers;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        // numbers 입력
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 비내림차순으로 출력하기 위해 오름차순으로 정렬
        Arrays.sort(numbers);

        int[] result = new int[M];  // 조합 결과를 저장할 배열
        sb = new StringBuilder();

        // 중복 조합 수행
        combination(0, 0, result);

        // 출력
        System.out.println(sb);

        br.close();
    }

    private static void combination(int depth, int start, int[] result) {
        // M개를 모두 선택했다면 재귀 종료
        if (depth == M) {
            // StringBuilder에 수열 결과값을 저장한다.
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        // result[depth]에서 마지막(이전)에 선택했던 수
        int lastNumber = Integer.MIN_VALUE;

        // 비내림차순이므로 자신보다 작은 값은 선택 못 함
        for (int i = start; i < N; i++) {
            // 중복을 피하기 위한 백트레킹 (numbers를 정렬해서 가능)
            if (lastNumber == numbers[i]) continue;

            result[depth] = numbers[i];
            combination(depth + 1, i, result);
            lastNumber = numbers[i];
        }
    }
}