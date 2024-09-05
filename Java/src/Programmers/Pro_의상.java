package Programmers;

import java.util.*;

class Pro_의상 {
    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 1;

        // HashMap에 각 의상 종류의 의상 개수를 저장한다. (의상종류=의상개수)
        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        // 해당 의상 종류를 선택하는 경우의 수 = 의상 개수 + 1
        // (의상 하나를 선택 + 하나도 고르지 않을 때)
        // 사건은 동시에 일어나므로 곱의 법칙을 사용한다.
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }

        // 모든 의상 종류를 고르지 않는 경우를 빼고 반환한다.
        return answer - 1;
    }
}
