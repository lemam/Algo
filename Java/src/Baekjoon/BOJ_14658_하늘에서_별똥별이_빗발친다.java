package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_14658_하늘에서_별똥별이_빗발친다 {
    private static class Star {
        int x, y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 구역 가로길이
        int M = Integer.parseInt(st.nextToken());   // 구역 세로길이
        int L = Integer.parseInt(st.nextToken());   // 트램펄린 한 변 길이
        int K = Integer.parseInt(st.nextToken());   // 별똥별의 수
        Star[] stars = new Star[K]; // 별똥별 좌표 배열

        // stars 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new Star(x, y);
        }

        int max = 0;    // 트램펄린에 떨어지는 별똥별의 수의 최대값

        // 모든 별똥별 중 2개를 선택해서 (star1.x, star2.y)을 좌상단이라 가정
        for (Star star1 : stars) {
            for (Star star2 : stars) {
                max = Math.max(max, countStar(star1.x, star2.y, stars, L));
            }
        }

        // 지구에 떨어지는 별똥별의 개수 출력
        System.out.println(K - max);

        br.close();
    }

    // 트램펄린 범위 안에 별똥별이 몇 개 들어가는지 확인
    private static int countStar(int cx, int cy, Star[] stars, int L) {
        int count = 0;

        for (Star star : stars) {
            if (star.x >= cx && star.x <= cx + L && star.y >= cy && star.y <= cy + L) {
                count++;
            }
        }

        return count;
    }
}
