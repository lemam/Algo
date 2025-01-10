package Baekjoon;

import java.io.*;

public class BOJ_2607_비슷한_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 단어의 개수
        String first = br.readLine();  // 첫번째 단어
        int firstSize = first.length();
        int answer = 0; // 비슷한 단어의 개수

        for (int i = 1; i < N; i++) {
            String str = br.readLine();
            int strSize = str.length();
            int count = 0;  // 같은 단어 개수
            int[] word = new int[26];   // 알파벳 개수를 저장할 배열

            // first의 문자의 종류별 개수를 저장한다.
            for (int j = 0; j < firstSize; j++) {
                word[first.charAt(j) - 'A']++;
            }

            // word에서 str과 같은 문자가 있으면 지우고 그 개수를 저장한다.
            for (int j = 0; j < strSize; j++) {
                int alpha = str.charAt(j) - 'A';
                if (word[alpha] > 0) {
                    count++;
                    word[alpha]--;
                }
            }

            // first 길이와 str 길이의 차이를 확인한다.
            // 1. 서로의 길이가 같거나 한 글자만 바꾸면 되는 경우
            if (firstSize == strSize && (firstSize == count || firstSize - 1 == count)) {
                answer++;
            }
            // 2. str의 문자를 한 개를 제거하면 되는 경우
            else if (firstSize == strSize - 1 && strSize - 1 == count) {
                answer++;
            }
            // 3. str의 문자를 한 개를 추가하면 되는 경우
            else if (firstSize == strSize + 1 && strSize == count) {
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }
}
