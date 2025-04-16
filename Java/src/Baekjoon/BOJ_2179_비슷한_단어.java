package Baekjoon;

import java.io.*;

public class BOJ_2179_비슷한_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 영단어의 개수
        String[] words = new String[N];             // 영단어 배열

        int idx1 = 0, idx2 = 0; // 가장 비슷한 두 단어의 인덱스
        int maxCount = 0;       // 접두사 길이의 최대값

        // words 입력
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 모든 단어 간의 접두사 탐색
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                // 두 단어의 길이 중 작은 값을 얻는다.
                int size = Math.min(words[i].length(), words[j].length());
                int count = 0;  // 같은 글자의 개수

                // 짧은 길이의 단어를 기준으로 접두사의 길이를 확인한다.
                for (int k = 0; k < size; k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) break;
                    count++;
                }

                // count가 최대값이면 인덱스도 갱신해준다.
                if (count > maxCount) {
                    idx1 = i;
                    idx2 = j;
                    maxCount = count;
                }
            }
        }

        // 출력
        System.out.println(words[idx1]);
        System.out.println(words[idx2]);

        br.close();
    }
}
