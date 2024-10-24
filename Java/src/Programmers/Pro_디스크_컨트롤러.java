package Programmers;

import java.util.*;

class Pro_디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int finishJobs = 0;  // 처리 완료된 요청 개수
        int jobsCopyIdx = 0;    // jobsCopy 배열의 인덱스
        int endTime = 0;    // 최근 작업이 끝난 시간
        int answer = 0;

        // jobs를 깊은 복사한 jobsCopy 배열을 만든다.
        int[][] jobsCopy = jobs.clone(); // [작업 요청 시점, 작업 소요시간]

        // jobsCopy 배열을 작업 요청 시점을 기준으로 오름차순 정렬한다.
        Arrays.sort(jobsCopy, (o1, o2) -> o1[0] - o2[0]);

        // 작업 소요시간을 기준으로 오름차순으로 정렬하는 우선순위 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        // 요청이 모두 수행될 때까지 반복
        while (finishJobs < jobsCopy.length) {
            // 하나의 작업이 완료되는 시점(endTime)까지 들어온 모든 요청을 큐에 넣는다.
            while (jobsCopyIdx < jobsCopy.length && jobsCopy[jobsCopyIdx][0] <= endTime) {
                pq.add(jobsCopy[jobsCopyIdx++]);
            }

            // 큐가 비어있다면 작업 완료 시간 이후에 다시 요청이 들어온다는 뜻이므로
            // endTime을 다음 작업의 요청 시간으로 맞춘다.
            if (pq.isEmpty()) {
                endTime = jobsCopy[jobsCopyIdx][0];
            }
            // 작업이 끝나기 전에 들어온 요청이 있다면 가장 수행시간이 짧은 요청부터 수행한다.
            else {
                int[] process = pq.poll();
                answer += process[1] + endTime - process[0];    // 소요시간 + 이전 작업이 끝난 시간 - 요청 시간
                endTime += process[1];
                finishJobs++;
            }
        }

        // 각 작업의 요청부터 종료까지 걸린 시간의 평균을 반환한다.
        return (int) Math.floor((double) answer / jobsCopy.length);
    }
}
