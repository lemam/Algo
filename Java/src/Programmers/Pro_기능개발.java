package Programmers;

import java.util.*;

class Pro_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 각 기능의 필요 작업 시간을 queue에 저장
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            double days = Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.add((int) days);
        }

        // 2. 앞선 기능이 배포될 때 뒤에 같이 배포되는 기능들이 몇 개인지 확인
        int deployDay = queue.peek();  // 실제 배포 날짜
        int count = 0;  // deployDay동안 배포된 기능 수
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int today = queue.poll();   // 오늘 = 현재 기능의 배포 가능 날짜

            // 오늘이 실제 배포 날보다 느린 경우,
            // 배포된 기능 수 저장 후 변수 초기화
            if (deployDay < today) {
                result.add(count);
                deployDay = today;
                count = 0;
            }

            // 오늘이 실제 배포 날보다 빠른 경우,
            // 배포 기능 수 증가
            count++;
        }

        result.add(count);  // 마지막 배포 저장

        // 3. 리스트를 배열로 바꿔 반환
        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
