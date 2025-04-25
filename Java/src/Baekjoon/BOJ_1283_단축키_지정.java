package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1283_단축키_지정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 옵션의 개수
        Set<Character> shortcut = new HashSet<>();  // 단축키 Set

        optionLoop:
        for (int op = 0; op < N; op++) {
            String option = br.readLine();  // 입력받은 옵션
            String[] words = option.split(" "); // 옵션을 이루는 단어들의 배열
            int wordSize = words.length;

            // 1. 단어들의 첫 번째 글자를 확인한다.
            for (int i = 0; i < wordSize; i++) {
                char ch = words[i].charAt(0);
                char upperCh = Character.toUpperCase(ch); // 첫 번째 글자 (대문자로 변환)

                // 첫 번째 글자로 지정된 단축키가 있는지 확인한다.
                if (!shortcut.contains(upperCh)) {
                    // 없다면 단축키로 지정한다.
                    shortcut.add(upperCh);

                    // 좌우에 괄호를 씌운 것으로 단어를 수정한다.
                    String result = "[" + ch + "]" + words[i].substring(1);
                    words[i] = result;

                    // 단어들을 합쳐 sb에 저장한다.
                    sb.append(String.join(" ", words)).append("\n");

                    // 다음 옵션으로 이동
                    continue optionLoop;
                }
            }

            // 2. 단어들의 나머지 글자를 순서대로 확인한다.
            for (int i = 0; i < wordSize; i++) {
                for (int j = 1; j < words[i].length(); j++) {
                    char ch = words[i].charAt(j);
                    char upperCh = Character.toUpperCase(ch);   // j 번째 글자 (대문자로 변환)

                    // 현재 글자로 지정된 단축키가 있는지 확인한다.
                    if (!shortcut.contains(upperCh)) {
                        // 없다면 단축키로 지정한다.
                        shortcut.add(upperCh);

                        // 좌우에 괄호를 씌운 것으로 단어를 수정한다.
                        String result = words[i].substring(0, j) + "[" + ch + "]" + words[i].substring(j + 1);
                        words[i] = result;

                        // 단어들을 합쳐 sb에 저장한다.
                        sb.append(String.join(" ", words)).append("\n");

                        // 다음 옵션으로 이동
                        continue optionLoop;
                    }
                }
            }

            // 3. 만들 수 없다면 그대로 sb에 저장한다.
            sb.append(option).append("\n");
        }

        // 출력
        System.out.println(sb);

        br.close();
    }
}
