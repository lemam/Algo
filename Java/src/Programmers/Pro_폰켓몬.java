package Programmers;

import java.util.*;

class Pro_폰켓몬 {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // 종류별 개수 세기
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int select = nums.length / 2;
        int type = map.keySet().size();

        // 선택 횟수가 폰켓몬 종류 이상이면 선택 횟수를 반환
        // 아니라면 종류 개수를 반환
        if (select <= type) return select;
        else return type;
    }
}
