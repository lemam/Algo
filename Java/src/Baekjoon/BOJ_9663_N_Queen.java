package Baekjoon;

import java.io.*;

public class BOJ_9663_N_Queen {
    private static int N, count = 0;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 놓아야할 퀸의 개수
        arr = new int[N];   // [행]=열 : NxN 체스판이므로 퀸 N개를 놓기 위해선 모든 행에 퀸이 있어야 한다.

        nQueen(0);
        System.out.println(count);

        br.close();
    }

    private static void nQueen(int depth) {
        // 퀸을 N개 모두 놓았다면 count를 증가시킨다.
        if (depth == N) {
            count++;
            return;
        }

        // 모든 열 탐색
        for (int i = 0; i < N; i++) {
            arr[depth] = i; // depth 행에 i 열 입력
            // 퀸을 놓을 수 있는 자리인지 검사
            // 맞다면 재귀 호출
            if (checkQueen(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    private static boolean checkQueen(int row) {
        // 자기보다 위에 있는 행 탐색
        for (int i = 0; i < row; i++) {
            // row행과 i행이 같은 열에 퀸이 있는 경우
            if (arr[row] == arr[i]) {
                return false;
            }

            // 대각선상에 퀸이 있는지 검사
            // 두 좌표 간의 행의 차와 열의 차가 같은 경우 대각선에 놓여 있음
            if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}
