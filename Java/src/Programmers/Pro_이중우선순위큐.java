package Programmers;

import java.util.*;

class Pro_이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] commands = operation.split(" ");

            // I 숫자 : 큐에 주어진 숫자를 삽입한다.
            if (commands[0].equals("I")) {
                int value = Integer.parseInt(commands[1]);
                minPq.add(value);
                maxPq.add(value);
            }
            // D 1 : 큐에서 최댓값을 삭제한다.
            else if (commands[1].equals("1") && !maxPq.isEmpty()) {
                minPq.remove(maxPq.poll());
            }
            // D -1 : 큐에서 최솟값을 삭제한다.
            else if (commands[1].equals("-1") && !minPq.isEmpty()) {
                maxPq.remove(minPq.poll());
            }
        }

        // 모든 연산을 처리한 후 큐가 비어있지 않으면 [최댓값, 최솟값]을 반환한다.
        if (!maxPq.isEmpty() && !minPq.isEmpty())
            return new int[]{maxPq.poll(), minPq.poll()};

        // 큐가 비어있으면 [0,0]을 반환한다.
        return new int[]{0, 0};
    }
}
