package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro_3차_파일명_정렬 {
    static class FileName implements Comparable<FileName> {
        String name;
        String head;
        int number;

        public FileName(String name) {
            this.name = name;

            // 숫자를 기준으로 문자열 추출
            this.head = name.split("[0-9]")[0].toUpperCase();

            // 길이는 head 다음 글자 ~ (5글자 인덱스 또는 문자열 끝 인덱스 중 최소값)
            String numStr = name.substring(this.head.length(), Math.min(this.head.length() + 5, name.length()));

            // 0 ~ 9를 제외한 문자들을 기준으로 문자열 추출
            numStr = numStr.split("[^0-9]")[0];
            this.number = Integer.parseInt(numStr);
        }

        @Override
        public int compareTo(FileName o) {
            int headDiff = this.head.compareTo(o.head);

            // HEAD가 같은 경우 HEAD 오름차순 정렬
            if (headDiff != 0) {
                return headDiff;
            }

            // HEAD가 같지 않은 경우 NUBMER 오름차순 정렬
            return this.number - o.number;
        }
    }


    public String[] solution(String[] files) {
        List<FileName> list = new ArrayList<>();

        // 리스트에 files를 이용하여 FileName 객체 리스트 초기화
        for (String file : files) {
            list.add(new FileName(file));
        }

        // FileName 객체 리스트 정렬
        Collections.sort(list);

        // 리스트를 String 배열로 변환
        String[] answer = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            answer[i] = list.get(i).name;
        }

        return answer;
    }
}
