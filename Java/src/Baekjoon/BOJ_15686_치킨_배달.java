package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨_배달 {
    private static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int N, M, homeSize, storeSize, answer;
    private static int[][] map;
    private static List<Point> homeList, storeList;
    private static boolean[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];    // 0: 빈 칸, 1: 집, 2: 치킨집
        homeList = new ArrayList<>();
        storeList = new ArrayList<>();

        // map 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    homeList.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    storeList.add(new Point(i, j));
                }
            }
        }

        homeSize = homeList.size();
        storeSize = storeList.size();

        answer = Integer.MAX_VALUE;
        sel = new boolean[storeSize];

        solution(0, 0);

        System.out.println(answer);

        br.close();
    }

    private static void solution(int start, int count) {
        if (count == M) {
            int cityChickenDist = 0;    // 도시의 치킨 거리 = 모든 집의 치킨 거리의 합
            
            for (int i = 0; i < homeSize; i++) {
                int minChickenDist = Integer.MAX_VALUE; // i번째 집의 치킨 거리 = 가장 가까운 치킨 집과의 거리

                for (int j = 0; j < storeSize; j++) {
                    // 선택한 치킨집인 경우
                    if (sel[j]) {
                        Point home = homeList.get(i);
                        Point store = storeList.get(j);
                        // 치킨집과 집 사이의 거리
                        int dist = Math.abs(home.row - store.row) + Math.abs(home.col - store.col);
                        // 최소값이면 갱신한다.
                        minChickenDist = Math.min(dist, minChickenDist);
                    }
                }

                cityChickenDist += minChickenDist;
            }

            // 도시의 치킨 거리가 최소값이면 갱신한다.
            answer = Math.min(cityChickenDist, answer);

            return;
        }

        // 순열
        for (int i = start; i < storeSize; i++) {
            sel[i] = true;
            solution(i + 1, count + 1);
            sel[i] = false;
        }
    }
}
