package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();
        String input;
        int total = 0;

        // 나무 종 이름과 개수 저장
        while ((input = br.readLine()) != null) {
            map.put(input, map.getOrDefault(input, 0) + 1);
            total++;
        }

        // 나무 종 이름을 오름차순으로 정렬
        ArrayList<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);

        // 그 종이 차지하는 비율을 백분율로 소수점 4째자리까지 반올림해 출력
        for (String key : keyList) {
            double ratio = (double) map.get(key) * 100 / total;
            sb.append(key + " " + String.format("%.4f", ratio)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
