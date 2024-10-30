package Programmers;

class Pro_입국심사 {
    public long solution(int n, int[] times) {
        // 시간범위 지정
        long start = 0;  // 시작 시간(분)
        long end = 1000000000 * 1000000000L;  // 최대종료시간(분) (사람수 x 심사시간)

        // 이진탐색
        while (end > start) {
            long minute = (start + end) / 2;    // 범위를 반으로 줄인다.

            // 시간 내 유요하면 최대종료시간을 minute으로 갱신
            if (isValid(times, minute, n)) {
                end = minute;
            }
            // 아니라면 시작시간을 minute + 1로 갱신
            else {
                start = minute + 1;
            }
        }

        return start;
    }

    private boolean isValid(int[] times, long minute, int n) {
        long count = 0;

        // minute 안에 심사할 수 있는 최대 사람 수 구하기
        for (int time : times) {
            count += minute / time;
        }

        return count >= n;
    }
}
