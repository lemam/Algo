package Programmers;

import java.util.*;

class Pro_모의고사 {
    public int[] solution(int[] answers) {
        int[] tester1 = {1, 2, 3, 4, 5};                // 1번 수포자
        int[] tester2 = {2, 1, 2, 3, 2, 4, 2, 5};       // 2번 수포자
        int[] tester3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3번 수포자
        int[] scores = new int[3];  // 각 수포자들의 시험 결과

        // 모든 문제 채점하기
        for (int i = 0; i < answers.length; i++) {
            if (tester1[i % tester1.length] == answers[i]) scores[0]++;
            if (tester2[i % tester2.length] == answers[i]) scores[1]++;
            if (tester3[i % tester3.length] == answers[i]) scores[2]++;
        }

        int maxNum = Arrays.stream(scores).max().getAsInt();    // 시험 결과 최고점
        List<Integer> answer = new ArrayList<>();

        // 시험 결과가 최대 점수와 같으면 answer에 추가
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxNum) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
