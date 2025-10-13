package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21939_문제_추천_시스템_Version_1 {
    private static class Problem implements Comparable<Problem> {
        int num, level;

        public Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.level == o.level)
                return Integer.compare(this.num, o.num);
            return Integer.compare(this.level, o.level);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<Problem> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());    // 문제 개수

        // 문제 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());   // 문제 번호
            int L = Integer.parseInt(st.nextToken());   // 난이도

            set.add(new Problem(P, L));
            map.put(P, L);
        }

        int M = Integer.parseInt(br.readLine());    // 명령어 개수

        // 명령어 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();    // 명령어

            // x가 1이면, 가장 어려운 문제 중 가장 큰 번호 출력
            // x가 -1이면, 가장 쉬운 문제 중 가장 작은 번호 출력
            if (command.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());

                if (x == 1)
                    sb.append(set.last().num).append("\n");
                else if (x == -1)
                    sb.append(set.first().num).append("\n");
            }
            // L 난이도에 P번 문제 추가
            else if (command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                set.add(new Problem(P, L));
                map.put(P, L);
            }
            // 문제 번호 P 제거
            else if (command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                int L = map.get(P);

                set.remove(new Problem(P, L));
            }
        }

        System.out.println(sb);

        br.close();
    }
}
