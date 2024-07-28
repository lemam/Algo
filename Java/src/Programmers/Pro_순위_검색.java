package Programmers;

import java.util.*;

class Pro_순위_검색 {
    private Map<String, List<Integer>> map;

    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        int[] answer = new int[query.length];

        // info가 속할 수 있는 모든 경우의 수를 구하여 key로, 점수는 value로 하여 map에 넣는다.
        for (String line : info) {
            makeSentence(line.split(" "), "", 0);
        }

        // map의 모든 key의 value를 오름차순으로 정렬한다.
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        // 각 쿼리도 map과 같이 [key, value] 형태의 배열로 바꾸고
        // 이분탐색을 통해 value(condition[1]) 이상의 점수를 받은 사람의 수를 구한다.
        for (int i = 0; i < query.length; i++) {
            String[] condition = query[i].replaceAll(" and ", "").split(" ");
            if (map.containsKey(condition[0]))
                answer[i] = binarySearch(condition[0], Integer.parseInt(condition[1]));
        }

        return answer;
    }

    // 이분 탐색
    private int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        // start: score 이상인 값들 중 처음 인덱스
        // 그러므로 start ~ list.size()-1 은 모두 score 이상의 값일 것.
        return list.size() - start;
    }

    // info가 포함될 수 있는 모든 문장 생성
    private void makeSentence(String[] parts, String key, int depth) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                map.put(key, list);
            }
            map.get(key).add(Integer.parseInt(parts[4]));
            return;
        }

        makeSentence(parts, key + "-", depth + 1);
        makeSentence(parts, key + parts[depth], depth + 1);
    }
}
