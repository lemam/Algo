package Programmers;

import java.util.*;

class Pro_단속_카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        // 도착지점을 기준으로 오름차순 정렬한다.
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int cam = Integer.MIN_VALUE;

        for (int[] route : routes) {
            // 현재 카메라의 위치가 차량 진입 지점보다 작으면
            if (cam < route[0]) {
                // 차량 진출 지점에 카메라를 설치한다.
                cam = route[1];
                answer++;
            }
        }

        return answer;
    }
}
