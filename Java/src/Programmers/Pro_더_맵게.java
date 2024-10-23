package Programmers;

import java.util.*;

class Pro_더_맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for (int num : scoville) {
            pq.add(num);
        }

        // pq의 크기가 2 이상일 때까지 반복한다.
        while (pq.size() >= 2) {
            // 가장 맵지 않은 음식의 스코빌 지수가 K 이상이면 섞은 횟수 반환
            if (pq.peek() >= K) return answer;

            // 가장 맵지 않은 음식 두 개
            int fist = pq.poll();
            int second = pq.poll();

            // 섞은 새로운 음식을 pq에 넣는다.
            pq.add(fist + (second * 2));
            answer++;
        }

        // 마지막 남은 음식의 스코빌 지수가 K 이상인지 확인한다.
        if (pq.peek() >= K) return answer;

        return -1;
    }
}
