package Programmers;

import java.util.*;

class Pro_가장_많이_받은_선물 {
    private String[] friendsCopy;
    private Map<String, Integer> giftMap, sendCounter, receivedCounter;
    private int[] result;

    public int solution(String[] friends, String[] gifts) {
        giftMap = new HashMap<>(); // 주고받은 선물 정보
        sendCounter = new HashMap<>(); // 준 선물 개수
        receivedCounter = new HashMap<>(); // 받은 선물 개수
        friendsCopy = friends;
        result = new int[friends.length];

        // 1. 이번 달 받은 선물 기록 저장
        for (String info : gifts) {
            // 두 사람이 주고받은 횟수 저장
            giftMap.put(info, giftMap.getOrDefault(info, 0) + 1);

            // 두 사람의 선물 주고 받은 횟수 카운트
            String[] arr = info.split(" ");
            sendCounter.put(arr[0], sendCounter.getOrDefault(arr[0], 0) + 1);
            receivedCounter.put(arr[1], receivedCounter.getOrDefault(arr[1], 0) + 1);
        }

        // 2. 모든 관계를 보며 다음 달에 가장 선물 많이 받는 사람 찾기
        combination(0, 0, new int[2], friends.length);

        return Arrays.stream(result).max().getAsInt();
    }

    private void combination(int depth, int start, int[] sel, int n) {
        // 3. 두 사람 중 다음 달에 선물을 받을 사람 찾기
        if (depth == 2) {
            String key = friendsCopy[sel[0]] + " " + friendsCopy[sel[1]];
            String reverseKey = friendsCopy[sel[1]] + " " + friendsCopy[sel[0]];

            // 1) 두 사람 사이에서 더 많은 선물을 준 사람
            int value = giftMap.getOrDefault(key, 0);
            int revserValue = giftMap.getOrDefault(reverseKey, 0);

            if (value > revserValue) {
                result[sel[0]]++;
            } else if (value < revserValue) {
                result[sel[1]]++;
            } else {
                // 2) 두 사람이 서로 주고받은 기록이 하나도 없거나 주고받은 수가 같은 경우. 선물 지수가 더 큰 사람
                // 선물 지수: 준 선물 개수 - 받은 선물 개수
                String left = key.split(" ")[0];
                String right = key.split(" ")[1];
                int leftIndex = sendCounter.getOrDefault(left, 0) - receivedCounter.getOrDefault(left, 0);
                int rightIndex = sendCounter.getOrDefault(right, 0) - receivedCounter.getOrDefault(right, 0);

                if (leftIndex > rightIndex) result[sel[0]]++;
                else if (leftIndex < rightIndex) result[sel[1]]++;
            }

            return;
        }

        for (int i = start; i < n; i++) {
            sel[depth] = i;
            combination(depth + 1, i + 1, sel, n);
        }
    }
}
