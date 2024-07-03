package Programmers;

import java.util.*;

public class Pro_메뉴_리뉴얼 {
    private HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();  // 조합을 담을 map: {조합=개수}
        List<String> result = new ArrayList<>();

        for (int number : course) {
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);   // 순서가 상관없으므로 미리 오름차순으로 정렬 => XY와 YX는 같은 조합
                makeComb(0, "", arr, number);   // number 크기의 조합 만들기
            }

            if (!map.isEmpty()) {
                // 가장 많이 주문된 조합의 개수
                int max = Collections.max(map.values());

                // 최소 2명 이상의 손님으로부터 주문된 단품 조합만 코스요리 후보로 포함
                // 가장 많이 주문된 조합을 모두 result에 넣는다.
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            result.add(key);
                        }
                    }
                }

                map.clear();    // map 초기화
            }
        }

        // 사전순으로 정렬
        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    private void makeComb(int depth, String output, char[] arr, int size) {
        // 조합을 완성한 경우 map에 넣고 종료
        if (output.length() == size) {
            map.put(output, map.getOrDefault(output, 0) + 1);
            return;
        }

        // 하나도 안 뽑았을 경우 종료
        if (depth >= arr.length) return;

        makeComb(depth + 1, output + arr[depth], arr, size);
        makeComb(depth + 1, output, arr, size);
    }
}
