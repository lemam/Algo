package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_22251_빌런_호석 {
    private static int N, K, P, X;

    // 표시등 배열
    private static final int[][] display = {{1, 1, 1, 0, 1, 1, 1}, // 0
            {0, 0, 1, 0, 0, 0, 1}, // 1
            {0, 1, 1, 1, 1, 1, 0}, // 2
            {0, 1, 1, 1, 0, 1, 1}, // 3
            {1, 0, 1, 1, 0, 0, 1}, // 4
            {1, 1, 0, 1, 0, 1, 1}, // 5
            {1, 1, 0, 1, 1, 1, 1}, // 6
            {0, 1, 1, 0, 0, 0, 1}, // 7
            {1, 1, 1, 1, 1, 1, 1}, // 8
            {1, 1, 1, 1, 0, 1, 1}}; // 9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 이용 가능한 엘리베이터 층 수
        K = Integer.parseInt(st.nextToken());   // 층수를 보여주는 디스플레이의 자리 수
        P = Integer.parseInt(st.nextToken());   // 최대 반전 시도 횟수
        X = Integer.parseInt(st.nextToken());   // 현재 멈춰있는 층
        long answer = 0; // 반전시킬 수 있는 LED를 고를 수 있는 경우의 수

        // 현재 층을 디스플레이 정보로 변환
        int[] xDigit = numToDigit(X);

        // 1 ~ N 중에 P개 이내의 표시등을 반전시켜 해당 수를 만들 수 있는지 확인
        answer = check(xDigit);

        System.out.println(answer);

        br.close();
    }

    // 반전시켜 만들 수 있는 수의 개수를 반환한다.
    private static long check(int[] xDigit) {
        long count = 0;

        // 표시등을 반전시켜 xDigit를 숫자 1 ~ N 중에 만들 수 있는 숫자는 몇 개인지 센다.
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (canReverse(i, xDigit)) count++;
        }

        return count;
    }

    // xDigit과 target의 표시등 상태를 비교하여 변환 가능한지 여부를 반환한다.
    // 표시등 상태의 차이가 P개 초과일 경우 false를 반환한다.
    private static boolean canReverse(int target, int[] xDigit) {
        int[] targetDigit = numToDigit(target);
        int diff = 0;

        // 각 자리 수 비교
        for (int i = 0; i < K; i++) {
            int xNum = xDigit[i];
            int tNum = targetDigit[i];

            // 각 표시등 상태 비교
            for (int j = 0; j < 7; j++) {
                if (display[xNum][j] != display[tNum][j]) {
                    diff++;
                    if (diff > P) return false; // 차이가 P개를 초과하면 target은 만들 수 없는 숫자라는 뜻
                }
            }
        }

        return true;
    }

    // 정수 X를 한 자리씩 나누어 K 크기의 배열에 저장하고 그 배열을 반환한다.
    private static int[] numToDigit(int X) {
        int[] result = new int[K];

        // 일의 자리부터 채워준다. 빈 자리는 0으로 채운다.
        for (int i = K - 1; i >= 0; i--) {
            result[i] = X % 10;
            X /= 10;
        }

        return result;
    }
}
