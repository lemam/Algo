package Programmers;

import java.util.*;

class Pro_실패율 {
    public int[] solution(int N, int[] stages) {
        int challengers = stages.length;    // 도전한 플레이어 수
        double[][] failRateArr = new double[N][2];  // 실패율 배열 [스테이지 번호, 실패율]

        // 모든 스테이지의 실패율 탐색
        for (int i = 1; i <= N; i++) {
            int fail = 0;   // 클리어하지 못한 플레이어 수

            // 현재 스테이지에서 클리어하지 못한 플레이어 찾기
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    fail++;
                }
            }

            // 실패율 계산하고 배열에 저장
            double failRate = (double) fail / challengers;

            // 도전한 플레이어 수가 0인 경우 분모가 0이기 때문에 NaN이 나오므로 0으로 값을 할당해준다.
            if (challengers == 0) failRate = 0;

            failRateArr[i - 1][0] = i;
            failRateArr[i - 1][1] = failRate;

            // 다음 스테이지 도전자 수 갱신
            challengers -= fail;
        }

        // 실패율을 기준으로 내림차순으로 정렬
        Arrays.sort(failRateArr, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[1], o1[1]);
            }
        });

        // 위에서 정렬한 배열의 스테이지 번호가 담겨 있는 배열 반환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRateArr[i][0];
        }

        return answer;
    }
}
