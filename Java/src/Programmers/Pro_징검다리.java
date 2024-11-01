package Programmers;

import java.util.*;

class Pro_징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks); // 바위의 위치를 오름차순으로 정렬한다.

        int left = 1;   // 지점 간 거리의 최소값
        int right = distance;   // 지점 간 거리의 최대값
        int answer = 0; // 지점 사이의 최소 거리 중 최대값 구하기

        while (left <= right) {
            int mid = (left + right) / 2;   // 지점 간 최소 거리

            // 제거한 바위의 개수가 n개 이하인 경우
            if (getRemoveRockCount(rocks, mid, distance) <= n) {
                answer = mid;
                left = mid + 1;
            }
            // 제거한 바위의 개수가 n개 초과인 경우
            else {
                right = mid - 1;
            }
        }

        return answer;
    }

    /**
     * 각 지점의 거리를 계산하여 최소 거리보다 작다면 바위를 제거하고 그 개수를 반환한다.
     *
     * @param rocks    바위 위치 배열
     * @param mid      지점 간 최소 거리
     * @param distance 도착점까지의 거리
     * @return 제거한 바위의 개수
     */
    private int getRemoveRockCount(int[] rocks, int mid, int distance) {
        int start = 0;  // 시작점
        int end = distance; // 끝점
        int count = 0;  // 제거한 바위 개수

        for (int rock : rocks) {
            // rock과 start의 거리가 최소 거리(mid)보다 작으면 바위를 제거한다.
            if (rock - start < mid) {
                count++;
                continue;
            }

            // 아니라면 시작점을 바위 위치로 갱신한다.
            start = rock;
        }

        // end와 start의 거리가 최소 거리(mid)보다 작으면 바위를 제거한다.
        if (end - start < mid) count++;

        return count;
    }
}
