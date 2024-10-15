package Programmers;

import java.util.*;

class Pro_프로세스 {
    public int solution(int[] priorities, int location) {
        List<Integer> rankList = new ArrayList<>();   // 내림차순 정렬된 priorities 배열
        Queue<int[]> queue = new LinkedList<>();    // [우선순위, 처음 위치]
        int idx = 0;    // rankList 인덱스
        int answer = 0;

        // rankList 초기화
        for (int i = 0; i < priorities.length; i++) {
            rankList.add(priorities[i]);
        }
        rankList.sort(Comparator.reverseOrder());

        // queue 초기화
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
        }

        // 현재 프로세스가 실행될 수 있는지 확인하기
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 프로세스의 우선 순위가 rankList[i]와 같은 경우
            // (= 프로세스의 우선 순위가 최우선 순위인 경우)
            if (curr[0] == rankList.get(idx)) {
                // 프로세스의 처음 위치가 location이면
                // 실행 순서를 answer에 저장하고 루프를 나간다.
                if (curr[1] == location) {
                    answer = rankList.size() - queue.size();
                    break;
                }

                idx++;
            }
            // 아니라면 현재 프로세스를 다시 큐에 넣는다.
            else {
                queue.add(curr);
            }
        }

        return answer;
    }
}
