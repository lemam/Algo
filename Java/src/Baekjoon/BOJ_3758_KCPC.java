package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_3758_KCPC {
    private static class Team implements Comparable<Team> {
        int idx;                    // 팀 번호
        int count = 0, time = 0;    // 제출 횟수, 마지막 제출 시간
        int[] score;                // 각 문제의 점수 배열

        Team(int idx, int num) {
            this.idx = idx;
            score = new int[num + 1];
        }

        // 최종 점수를 반환한다.
        int getTotalScore() {
            int sum = 0;
            for (int num : score) sum += num;
            return sum;
        }

        // 점수의 합산이 큰 순으로 정렬한다.
        // 만약 점수가 같은 경우, 횟수가 더 작은 순으로 정렬한다.
        // 만약 횟수도 같다면, 마지막 제출 시간이 더 빠른(작은) 순으로 정렬한다.
        @Override
        public int compareTo(Team t) {
            if (t == null) return 0;

            int sum1 = this.getTotalScore();
            int sum2 = t.getTotalScore();

            if (sum1 == sum2) {
                if (this.count == t.count)
                    return this.time - t.time;
                return this.count - t.count;
            }
            return sum2 - sum1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   // 팀의 개수
            int k = Integer.parseInt(st.nextToken());   // 문제의 개수
            int t = Integer.parseInt(st.nextToken());   // 나의 팀 ID
            int m = Integer.parseInt(st.nextToken());   // 로그 엔트리의 개수

            Team[] board = new Team[n + 1];    // 점수판 배열

            // board 배열의 Team 객체 초기화
            for (int i = 1; i <= n; i++) {
                board[i] = new Team(i, k);
            }

            // 로그 확인하기
            for (int l = 1; l <= m; l++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());   // 팀의 ID
                int j = Integer.parseInt(st.nextToken());   // 문제 번호
                int s = Integer.parseInt(st.nextToken());   // 획득한 점수

                // i팀의 j번 문제의 점수를 최댓값으로 갱신한다.
                board[i].score[j] = Math.max(board[i].score[j], s);
                board[i].count++;   // 제출 횟수 + 1
                board[i].time = l;  // 마지막 제출 시간 저장
            }

            // 문제에 주어진 조건에 맞게 정렬한다.
            Arrays.sort(board);

            // 내 팀의 순위를 출력한다.
            for (int rank = 1; rank <= n; rank++) {
                if (board[rank].idx == t) {
                    sb.append(rank).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}