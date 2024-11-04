package Programmers;

public class Pro_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        // 학생이 가지고 있는 체육복의 수
        // (-1: 체육복 도난당함, 0: 자기 체육복 있음, 1: 여벌 체육복 있음)
        int[] students = new int[n + 1];
        int answer = 0; // 체육수업을 들을 수 있는 학생 최댓값

        for (int i : lost) students[i]--;
        for (int i : reserve) students[i]++;

        for (int i = 1; i < students.length; i++) {
            // 1. 체육복이 있는 학생인 경우
            if (students[i] >= 0) continue;

            // 2. 체육복이 없는 학생인 경우
            // 앞(왼쪽)번호 학생 확인
            if (i - 1 > 0 && students[i - 1] > 0) {
                students[i - 1]--;
                students[i]++;
            }
            // 뒷(오른쪽)번호 학생 확인
            else if (i + 1 <= n && students[i + 1] > 0) {
                students[i + 1]--;
                students[i]++;
            }
        }

        // 체육복이 있는 학생들의 수 세기
        for (int i = 1; i < students.length; i++) {
            if (students[i] >= 0) answer++;
        }

        return answer;
    }
}
