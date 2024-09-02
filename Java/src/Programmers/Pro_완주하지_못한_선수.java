package Programmers;

import java.util.*;

class Pro_완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        for (String runner : completion) {
            if (map.containsKey(runner)) {
                int count = map.get(runner) - 1;
                if (count == 0) map.remove(runner);
                else map.put(runner, count);
            } else {
                return runner;
            }
        }

        return map.keySet().iterator().next();
    }
}
