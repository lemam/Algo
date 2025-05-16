package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9527_1의_개수_세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // `2^i`까지 등장한 1의 개수를 저장하는 배열
        // 크기가 55인 이유: long의 범위는 `10^18`이므로, `2^54` 정도까지 커버하기 위해
        long[] dp = new long[55];
        // 계산하는 법

        // 1. 누적합 계산
        setDp(dp);

        // 2. B의 누적합 - (A-1)의 누적합 구하기
        long answer = countOne(B, dp) - countOne(A - 1, dp);

        // 3. 출력
        System.out.println(answer);

        br.close();
    }

    // 1부터 N까지 이진수로 표현된 모든 수에서 등장한 1의 개수를 반환한다.
    private static long countOne(long N, long[] dp) {
        // 비트 연산자(&): AND 연산, 둘 다 1이라면 1, 아니면 0
        // 주로 N의 마지막 비트가 1인지 확인할 때 사용
        // 0번째 비트가 1이라면 count를 1부터 시작
        long count = N & 1; // 1의 개수

        // 이진수에서 가장 큰 비트 위치: floor(log₂(N))
        // 하지만 자바에서는 log₂ 함수가 없으므로 밑변환 공식 이용
        // log₂(N) = log₁₀(N) / log₁₀(2) = Math.log(N) / Math.log(2)
        int size = (int) (Math.log(N) / Math.log(2));   // 최상위 비트 위치

        // 최상위부터 확인
        for (int i = size; i > 0; i--) {
            // N의 i번째 비트가 1인지 확인
            if ((N & (1L << i)) != 0L) {
                // 이전 누적합 + (현재 비트가 1일 때 만들 수 있는 모든 1의 개수)
                // (N - (1L << i) + 1): i번째 비트가 무조건 1일 때 만들 수 있는 모든 숫자는 [2^i ~ N]까지, 그 범위의 수 개수는 N - 2^i + 1
                count += dp[i - 1] + (N - (1L << i) + 1);
                N -= (1L << i); // 비트 이동 (계산한 범위 제거)
            }
        }

        return count;
    }

    // 1부터 `2^i`까지의 모든 수에서 1이 몇 번 나왔는지를 미리 계산한다.
    // 점화식: dp[i] = dp[i - 1] * 2 + 2^i
    // 쉬프트 연산자(<<): `x << n` == `x * 2^n`
    private static void setDp(long[] dp) {
        dp[0] = 1;  // 초기화

        // 점화식 적용
        // DP[i-1] << 1 : DP[i-1] × 2
        // 1L << i : 2^i
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
    }
}
