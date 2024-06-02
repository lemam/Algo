package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro_3차_압축 {
    public static int[] solution(String msg) {
        // 1. 사전 초기화
        List<String> dict = new ArrayList<>(Arrays.asList("", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
        List<Integer> result = new ArrayList<>();   // 색인 번호 저장 배열

        // 2. 색인 번호 알아내기
        int idx = 0;
        int msgLength = msg.length();

        while (idx < msgLength) {
            String word = msg.charAt(idx) + "";  // 현재 입력
            int length = 1; // 현재 입력 단어 길이

            while (true) {
                // 다음 글자가 존재하는 경우
                if (idx + length < msgLength) {
                    char next = msg.charAt(idx + length);  // 다음 글자
                    String newWord = word + next;   // 새로운 단어

                    // 새로운 단어가 사전에 존재하는 경우
                    if (dict.contains(newWord)) {
                        // 현재 입력을 새로운 단어 변경
                        word = newWord;
                        length++;
                    }
                    // 새로운 단어가 사전에 존재하지 않는 경우
                    else {
                        // result에 현재 입력의 색인 번호 저장
                        result.add(dict.indexOf(word));
                        // 새로운 단어를 사전에 추가
                        dict.add(newWord);

                        // 인덱스 이동
                        idx += length;
                        break;
                    }
                }
                // 다음 글자가 존재하지 않는 경우
                else {
                    // result에 현재 입력의 색인 번호 저장
                    result.add(dict.indexOf(word));

                    // 인덱스 이동
                    idx += length;
                    break;
                }
            }
        }

        // 3. 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
