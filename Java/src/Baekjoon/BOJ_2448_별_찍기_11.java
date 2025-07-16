package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2448_별_찍기_11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] stars = new char[N][2 * N - 1];

        // stars 초기화
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        // 별 그리기
        drawStar(0, N - 1, N, stars);

        StringBuilder sb = new StringBuilder();

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

        br.close();
    }

    private static void drawStar(int row, int col, int N, char[][] stars) {
        // `k = 0`의 삼각형을 그린다.
        if (N == 3) {
            stars[row][col] = '*';
            stars[row + 1][col - 1] = stars[row + 1][col + 1] = '*';
            stars[row + 2][col - 2]
                    = stars[row + 2][col - 1]
                    = stars[row + 2][col]
                    = stars[row + 2][col + 1]
                    = stars[row + 2][col + 2]
                    = '*';
        }
        // 3개의 작은 삼각형으로 나누어 각 삼각형의 시작점으로 이동해 재귀한다.
        // 시작점: 삼각형의 맨 윗 꼭짓점
        else {
            int bias = N / 2;
            drawStar(row, col, bias, stars);
            drawStar(row + bias, col - bias, bias, stars);
            drawStar(row + bias, col + bias, bias, stars);
        }
    }
}