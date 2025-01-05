package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20437_문자열_게임_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // 게임의 수

        while (T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            char[] alphas = W.toCharArray();    // W를 문자열로 바꾼 배열
            Map<Character, List<Integer>> map = new HashMap<>();    // 각 문자의 위치값을 리스트에 담아 저장할 map

            int min = 10000;    // 최소 길이
            int max = -1;       // 최대 길이

            // map에 값 저장하기
            for (int i = 0; i < alphas.length; i++) {
                List<Integer> list = map.getOrDefault(alphas[i], new ArrayList<>());
                list.add(i);
                map.put(alphas[i], list);
            }

            // map을 탐색한다.
            for (char key : map.keySet()) {
                List<Integer> list = map.get(key);

                // 뒤에서부터 문자를 탐색한다.
                for (int i = list.size() - 1; i >= K - 1; i--) {
                    // 현재 위치부터 문자를 K개 포함하는 문자열의 길이를 구한다.
                    int length = list.get(i) - list.get(i - K + 1) + 1;

                    // 사용한 문자를 list에서 삭제한다.
                    list.remove(list.size() - 1);

                    // 최소 길이와 최대 길이를 갱신한다.
                    min = Math.min(length, min);
                    max = Math.max(length, max);
                }
            }

            // 3번과 4번에서 구한 연속 문자열의 길이를 출력한다.
            // 만족하는 연속 문자열이 없을 시 -1을 출력한다.
            if (max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }

        br.close();
    }
}
