package Programmers;

public class Pro_조이스틱 {
    public int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수 최솟값
        int length = name.length();
        int minMove = length - 1;   // 최소 좌우 움직임 수

        for (int i = 0; i < length; i++) {
            // 1. 상하 이동
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 2. 좌우 이동
            int nextIdx = i + 1;    // 다음 글자 인덱스

            // 연속되는 A의 개수 확인한다.
            while (nextIdx < length && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            // 순서대로 가는 것과 뒤로 돌아가는 것 중 이동 수가 작은 것을 선택한다.
            // i + i + (len - next) = 원점에서 오른쪽으로 i까지 이동 + 왼쪽으로 i까지 이동 + 왼쪽으로 (len - next)까지 이동
            // (len - next) + (len - next) + i = 원점에서 왼쪽으로 (len - next)까지 이동 + 오른쪽으로 (len - next)까지 이동 + 오른쪽으로 i까지 이동
            minMove = Math.min(minMove, Math.min(i * 2 + length - nextIdx, i + (length - nextIdx) * 2));
        }

        answer += minMove;

        return answer;
    }
}
