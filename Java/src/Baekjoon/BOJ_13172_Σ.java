package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13172_Σ {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int M = Integer.parseInt(br.readLine());    // 주사위 수
        long answer = 0;    // 모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 주사위 면의 개수
            int S = Integer.parseInt(st.nextToken());   // 모든 면에 적힌 수의 합

            // 각 주사위에서 얻을 수 있는 기댓값 = a * b^(-1) modX
            // b^(-1) modX == b^(X-2) == getReverse(N, MOD - 2)
            long result = (S * getReverse(N, MOD - 2)) % MOD;

            // 모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값
            // = 각 주사위에서 얻을 수 있는 기댓값들의 합
            answer += result % MOD;
        }

        System.out.println(answer % MOD);

        br.close();
    }

    // 분할 정복으로 b의 역원 구하기
    // x -> 밑(b), y -> 지수
    private static long getReverse(long x, long y) {
        // 지수가 1일 경우 그대로 반환
        if (y == 1) return x;

        // 지수를 분할한다.
        long value = getReverse(x, y / 2);

        // 지수가 홀수이면 `A^(n/2) * A^(n/2) * A`를 구한다.
        if (y % 2 == 1)
            return value * value % MOD * x % MOD;

        // 지수가 짝수이면 `A^(n/2) * A^(n/2)`를 구한다.
        return value * value % MOD;
    }
}