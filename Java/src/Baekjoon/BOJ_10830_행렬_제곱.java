package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10830_행렬_제곱 {
    private static final int MOD = 1000;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] origin = new int[N][N];

        // origin 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                /*
                 * B=1 일 때는 pow과정에서 바로 A가 반환 될 수 있다.
                 * 이 때의 경우 만약 원소가 1000이상일 경우 pow메소드에서 모듈러연산이
                 * 실행되지 않기 때문에 오답이 되어버린다.
                 *
                 * 이를 방지하기 위해 초기 행렬에도 1000으로 나눈 나머지 값으로
                 * 초기화를 해준다.
                 */
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        // 행렬 origin을 B제곱하기
        int[][] result = pow(origin, B);

        // 출력
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    // 행렬 제곱 분할정복
    private static int[][] pow(int[][] A, long exp) {
        // 지수가 1이면 A를 반환한다.
        if (exp == 1L) return A;

        // 지수를 절반으로 분할하여 재귀호출
        int[][] ret = pow(A, exp / 2);

        // 하위 재귀에서 얻은 행렬을 제곱해준다.
        ret = multiply(ret, ret);

        // 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
        if (exp % 2 == 1L) {
            ret = multiply(ret, A);
        }

        return ret;
    }

    // 두 행렬 o1, o2의 곱을 반환
    private static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;   // 행렬 원소 연산이 끝나면 MOD 나머지 연산
                }
            }
        }

        return ret;
    }
}