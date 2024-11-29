package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9017_크로스_컨트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());    // 모든 선수의 수
            int[] ranks = new int[N];    // 입력값을 저장할 배열
            Map<Integer, Integer> teamMap = new HashMap<>();   // 각 팀의 선수의 수를 저장할 Map

            // 1. 결과를 ranks에 저장하고, teamCountMap로 팀의 선수의 수를 센다.
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int data = Integer.parseInt(st.nextToken());
                teamMap.put(data, teamMap.getOrDefault(data, 0) + 1);
                ranks[i] = data;
            }

            int[] fifthGoalIdx = new int[teamMap.size() + 1];  // 5번째 선수 기록을 저장할 배열
            Map<Integer, Integer> scoreMap = new HashMap<>();   // 각 팀의 상위 4명의 점수 총합을 저장할 Map
            Map<Integer, Integer> countMap = new HashMap<>();    // 각 팀의 현재 탐색 횟수를 저장할 Map
            int score = 1;  // 현재 점수

            // 결과 기록을 탐색한다.
            for (int teamNumber : ranks) {
                // 현재 팀이 6인보다 작으면 계산하지 않는다.
                if (teamMap.get(teamNumber) < 6) continue;

                // 현재 팀의 탐색 횟수를 하나 센다.
                countMap.put(teamNumber, countMap.getOrDefault(teamNumber, 0) + 1);

                // 현재 팀의 탐색 횟수가 4번 이하이면 점수를 합한다.
                if (countMap.get(teamNumber) <= 4) {
                    scoreMap.put(teamNumber, scoreMap.getOrDefault(teamNumber, 0) + score);
                }
                // 현재 팀의 탐색 횟수가 5번이면 5번째 선수의 기록을 저장한다.
                else if (countMap.get(teamNumber) == 5) {
                    fifthGoalIdx[teamNumber] = score;
                }

                // 점수를 하나 올린다. (자격 미달은 팀은 점수에 영향을 주면 안 되므로 따로 카운트)
                score++;
            }

            List<Integer> keyData = new ArrayList<>(scoreMap.keySet()); // 총합 점수를 가진 팀 key 리스트

            // 점수가 더 낮은 순서대로 정렬한다.
            // 만약 점수가 서로 같다면 5번째 선수의 점수가 더 낮은 순서대로 정렬한다.
            keyData.sort((x, y) -> {
                if (Objects.equals(scoreMap.get(x), scoreMap.get(y))) {
                    return fifthGoalIdx[x] - fifthGoalIdx[y];
                } else {
                    return scoreMap.get(x) - scoreMap.get(y);
                }
            });

            // 정렬된 첫 번째 팀의 번호를 출력한다.
            System.out.println(keyData.get(0));
        }

        br.close();
    }
}
