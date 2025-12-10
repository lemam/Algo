package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1620_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken());   // 문제 개수
        Map<String, String> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            String number = Integer.toString(i);
            map.put(name, number);
            map.put(number, name);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(map.get(input)).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}