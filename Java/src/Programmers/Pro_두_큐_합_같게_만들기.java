package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        int answer = 0;

        for (int num : queue1) q1.add(num);
        for (int num : queue2) q2.add(num);

        // 두 큐의 합이 홀수이면 같게 만들 수 없다.
        if ((sum1 + sum2) % 2 != 0) return -1;

        while (sum1 != sum2) {
            // (큐1 + 큐2) * 2 == 한 큐의 길이 * 4
            // 답이 나오지 않는 최악의 경우에 양쪽 큐가 원래의 상태로 돌아오기까지 필요한 횟수
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }

            int curr = 0;

            // 각 원소의 합이 더 큰 큐에서 원소 하나를 추출한다.
            if (sum1 > sum2) {
                curr = q1.poll();
                q2.add(curr);
                sum1 -= (long) curr;
                sum2 += (long) curr;
            } else if (sum1 < sum2) {
                curr = q2.poll();
                q1.add(curr);
                sum1 += (long) curr;
                sum2 -= (long) curr;
            }

            answer++;
        }

        return answer;
    }
}
