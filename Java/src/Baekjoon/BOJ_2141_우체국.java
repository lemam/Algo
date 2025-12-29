package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2141_우체국 {
    private static class Village implements Comparable<Village> {
        int pos, value;

        Village(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }

        @Override
        public int compareTo(Village o) {
            return this.pos - o.pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Village[] villages = new Village[N];

        long sum = 0;    // 총 인구수

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            villages[i] = new Village(pos, value);
            sum += value;
        }

        // 마을 위치 기준 오름차순 정렬
        Arrays.sort(villages);

        long result = 0;    // 누적 인구수
        long mid = (sum + 1) / 2;   // 중간값 (홀수인 경우, 항상 절반 이상이 되도록)

        for (int i = 0; i < N; i++) {
            result += villages[i].value;

            // 우체국의 위치가 총 인구수의 중간값이면 양쪽 마을의 사람 수가 균일해짐
            // 누적 인구수가 중간값 이상이 되는 마을에 우체국 설치
            if (result >= mid) {
                System.out.println(villages[i].pos);
                break;
            }
        }

        br.close();
    }
}
