package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_21944_문제_추천_시스템_Version_2 {
    private static class Problem implements Comparable<Problem> {
        int num, level, group;

        public Problem(int num, int level, int group) {
            this.num = num;
            this.level = level;
            this.group = group;
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
        HashMap<Integer, int[]> map = new HashMap<>();
        List<TreeSet<Problem>> subSets = new ArrayList<>();

        // 100 이유?
        for (int i = 0; i <= 100; i++) {
            subSets.add(new TreeSet<>());
        }

        int N = Integer.parseInt(br.readLine());    // 문제 개수

        // 문제 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());   // 문제 번호
            int L = Integer.parseInt(st.nextToken());   // 난이도
            int G = Integer.parseInt(st.nextToken());   // 알고리즘 분류

            set.add(new Problem(P, L, G));
            subSets.get(G).add(new Problem(P, L, G));
            map.put(P, new int[]{L, G});
        }

        int M = Integer.parseInt(br.readLine());    // 명령어 개수

        // 명령어 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();    // 명령어

            switch (command) {
                // x가 1이면, 알고리즘 분류가 G인 문제 중 가장 어려운 문제이면서 가장 큰 번호를 출력
                // x가 -1이면, 알고리즘 분류가 G인 문제 중 가장 쉬운 문제이면서 가장 작은 번호 출력
                case "recommend": {
                    int G = Integer.parseInt(st.nextToken());
                    int x = Integer.parseInt(st.nextToken());

                    if (x == 1)
                        sb.append(subSets.get(G).last().num).append("\n");
                    else if (x == -1)
                        sb.append(subSets.get(G).first().num).append("\n");
                    break;
                }
                // x가 1이면, 가장 어려운 문제 중 가장 큰 번호를 출력
                // x가 -1이면, 가장 쉬운 문제 중 가장 작은 번호를 출력
                case "recommend2": {
                    int x = Integer.parseInt(st.nextToken());

                    if (x == 1)
                        sb.append(set.last().num).append("\n");
                    else if (x == -1)
                        sb.append(set.first().num).append("\n");

                    break;
                }
                // x가 1이면, 난이도 L 이상의 문제 중 가장 쉬운 문제이면서 가장 작은 번호를 출력, 없으면 -1 출력
                // x가 -1이면, 난이도 L 미만의 문제 중 가장 어려운 문제이면서 가장 큰 번호를 출력, 없으면 -1 출력
                case "recommend3": {
                    int x = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());

                    if (x == 1) {
                        // ceiling() : 제공된 값보다 크거나 같은 값 중 가장 작은 값
                        Problem p = set.ceiling(new Problem(0, L, 0));

                        if (p == null) sb.append("-1").append("\n");
                        else sb.append(p.num).append("\n");
                    } else if (x == -1) {
                        // lower() : 제공된 값보다 작은 값 중 가장 큰 값
                        Problem p = set.lower(new Problem(0, L, 0));

                        if (p == null) sb.append("-1").append("\n");
                        else sb.append(p.num).append("\n");
                    }

                    break;
                }
                // L 난이도이고 G 알고리즘 분류인 P번 문제 추가
                case "add": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    int G = Integer.parseInt(st.nextToken());

                    set.add(new Problem(P, L, G));
                    subSets.get(G).add(new Problem(P, L, G));
                    map.put(P, new int[]{L, G});

                    break;
                }
                // 문제 번호 P 제거
                case "solved": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = map.get(P)[0];
                    int G = map.get(P)[1];

                    set.remove(new Problem(P, L, G));
                    subSets.get(G).remove(new Problem(P, L, G));
                    map.remove(P);
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}
