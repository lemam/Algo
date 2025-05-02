package Baekjoon;

import java.io.*;

public class BOJ_17615_볼_모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 공의 개수
        String balls = br.readLine();   // 공 문자열

        int totalR = 0; // R의 전체 개수
        int totalB = 0; // B의 전체 개수

        // 전체 R, B의 개수 세기
        for (char ball : balls.toCharArray()) {
            if (ball == 'R') totalR++;
            else totalB++;
        }

        // 왼쪽 연속된 R의 개수
        int leftR = 0;
        while (leftR < N && balls.charAt(leftR) == 'R') {
            leftR++;
        }

        // 오른쪽 연속된 R의 개수
        int rightR = 0;
        while (rightR < N && balls.charAt(N - 1 - rightR) == 'R') {
            rightR++;
        }

        // 왼쪽 연속된 B의 개수
        int leftB = 0;
        while (leftB < N && balls.charAt(leftB) == 'B') {
            leftB++;
        }

        // 오른쪽 연속된 B의 개수
        int rightB = 0;
        while (rightB < N && balls.charAt(N - 1 - rightB) == 'B') {
            rightB++;
        }

        // 4가지 경우 중 최소 이동 횟수 찾기
        int answer = Integer.MAX_VALUE;
        answer = Math.min(answer, totalR - leftR);
        answer = Math.min(answer, totalR - rightR);
        answer = Math.min(answer, totalB - leftB);
        answer = Math.min(answer, totalB - rightB);

        System.out.println(answer);

        br.close();
    }
}
