package Programmers;

public class Pro_1차_다트_게임 {
    public int solution(String dartResult) {
        int n = 0;  // 게임 획수 (0부터 시작)
        int idx = 0;    // dartResult 탐색 시작할 인덱스
        int[] scoreArr = new int[3];    // 점수 배열

        // 게임을 3번 진행
        while (n < 3) {
            int score = 0;  // 현재 점수

            // 점수가 10인지 판단
            if (dartResult.charAt(idx) == '1') {
                if (dartResult.charAt(idx + 1) == '0') {
                    score = 10;
                    idx++;  // 2글자를 사용했으므로
                } else {
                    score = 1;
                }
            } else {
                score = dartResult.charAt(idx) - '0';
            }

            char bonus = dartResult.charAt(idx + 1);    // 보너스
            char option = ' ';  // 옵션

            // 옵션이 있는지 판단
            if (idx + 2 < dartResult.length()) {
                option = dartResult.charAt(idx + 2);
            }

            // 보너스 점수 계산
            switch (bonus) {
                // 1제곱
                case 'S':
                    break;
                // 2제곱
                case 'D':
                    score = (int) Math.pow(score, 2);
                    break;
                // 3제곱
                case 'T':
                    score = (int) Math.pow(score, 3);
                    break;
            }

            // 옵션 점수 계산 & 다음 탐색 인덱스 이동
            switch (option) {
                // 스타상 : n, n-1의 점수 2배
                case '*':
                    score *= 2;
                    if (n > 0) scoreArr[n - 1] *= 2;
                    idx += 3;
                    break;
                // 아차상 : n의 점수 마이너스
                case '#':
                    score *= -1;
                    idx += 3;
                    break;
                // 옵션이 없는 경우
                default:
                    idx += 2;
                    break;
            }

            // 점수 저장 & 다음 게임으로 이동
            scoreArr[n++] = score;
        }

        int answer = 0;

        // 점수 합산
        for (int score : scoreArr) {
            answer += score;
        }

        return answer;
    }
}
