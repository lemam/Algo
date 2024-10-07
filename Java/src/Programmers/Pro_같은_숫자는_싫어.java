package Programmers;

import java.util.*;

public class Pro_같은_숫자는_싫어 {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1;

        for (int num : arr) {
            if (num != prev) result.add(num);
            prev = num;
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
