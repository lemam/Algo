package Programmers;

import java.util.*;

class Pro_다리를_지나는_트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;    // 다리에 올라간 트럭의 무게의 합
        int time = 0;   // 소요된 시간

        for (int truck : truck_weights) {
            while (true) {
                // 1. 큐가 비어있는 경우
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                // 2. 큐에 자리가 없는 경우
                else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                }
                // 3. 큐에 자리가 남은 경우
                else {
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    // 아니라면 0 넣기
                    else {
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭 이동 시간(다리 길이)까지 포함해서 반환
        return time + bridge_length;
    }
}
