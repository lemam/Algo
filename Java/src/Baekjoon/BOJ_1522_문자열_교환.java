package Baekjoon;

import java.io.*;

public class BOJ_1522_문자열_교환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int size = str.length();

        int aLength = 0;    // a의 길이(개수)
        int answer = Integer.MAX_VALUE; // 교환 회수의 최솟값

        // a의 개수를 센다.
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'a') {
                aLength++;
            }
        }

        // 문자열을 순회하며 i부터 시작하여 aLength 크기의 범위에서 b의 개수를 확인한다.
        for (int i = 0; i < size; i++) {
            int bCount = 0;

            // b의 개수를 센다.
            // = 범위 안에 있는 b의 개수만큼 외부의 a와 교환하면 연속된 a를 만들 수 있음
            for (int j = i; j < i + aLength; j++) {
                // 문자열은 원형이므로 처음 인덱스로 돌아가도록 설정한다.
                if (str.charAt(j % size) == 'b') {
                    bCount++;
                }
            }

            answer = Math.min(answer, bCount);
        }

        System.out.println(answer);

        br.close();
    }
}