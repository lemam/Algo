package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1629_곱셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());  // 밑
        long B = Long.parseLong(st.nextToken());  // 지수
        long C = Long.parseLong(st.nextToken());  // 나눌 값

        System.out.println(pow(A, B, C));

        br.close();
    }

    // A = 밑, n = 지수, C = 나눌 값
    private static long pow(long A, long n, long C) {
        // 지수가 1일 경우 `A^1`이므로 A 그대로를 뜻한다.
        // 이후 C로 나눈 나머지 값을 반환한다.
        if (n == 1) return A % C;

        // 지수의 절반에 해당하는 `A^(n/2)`을 구한다.
        long temp = pow(A, n / 2, C);

        // 지수가 홀수이면
        // `A^(n/2) * A^(n/2) * A`를 구한다.
        // 이후 모듈러 연산을 활용해 C로 나눈 나머지 값을 반환한다.
        if (n % 2 == 1)
            return (temp * temp % C) * A % C;

        // 지수가 짝수이면
        // `A^(n/2) * A^(n/2)`를 구한다.
        // 이후 모듈러 연산을 활용해 C로 나눈 나머지 값을 반환한다.
        return temp * temp % C;
    }
}
