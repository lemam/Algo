package Baekjoon;

import java.io.*;

public class BOJ_1515_수_이어_쓰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 입력 받은 문자열
        int length = str.length();

        int base = 0;       // 비교할 숫자
        int pointer = 0;    // 비교할 위치

        // pointer가 문자열 길이보다 작은 동안 반복한다.
        while (pointer < length) {
            base++;

            String temp = String.valueOf(base);
            int tempSize = temp.length();

            // base를 왼쪽부터 한 글자씩 pointer 위치의 글자와 비교한다.
            for (int i = 0; i < tempSize; i++) {
                // 같다면 pointer를 한 칸 이동시킨다.
                if (str.charAt(pointer) == temp.charAt(i)) {
                    pointer++;
                }

                // pointer가 문자열 끝에 도착하면 탐색을 중단한다.
                if (pointer == length) break;
            }
        }

        System.out.println(base);

        br.close();
    }
}

