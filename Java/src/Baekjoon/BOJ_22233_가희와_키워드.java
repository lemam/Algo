package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_22233_가희와_키워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 메모장의 키워드 개수
        int M = Integer.parseInt(st.nextToken());   // 블로그 글 개수
        Map<String, Integer> map = new HashMap<>(); // 메모장의 키워드를 저장할 map

        // 키워드 입력
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        // 블로그 글의 키워드 확인
        for (int i = 0; i < M; i++) {
            String[] keywords = br.readLine().split(",");

            // 메모장에 있는 키워드이면 메모장에서 삭제한다.
            for (String keyword : keywords) {
                map.remove(keyword);
            }

            // i번째 글을 쓰고 난 후 메모장의 남아 있는 키워드의 개수를 저장
            sb.append(map.size()).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
