package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro_개인정보_수집_유효기간 {
    public class Date {
        int year;
        int month;
        int day;

        public Date(String str) {
            String[] arr = str.split("\\.");
            this.year = Integer.parseInt(arr[0]);
            this.month = Integer.parseInt(arr[1]);
            this.day = Integer.parseInt(arr[2]);
        }

        public int getDayInDate() {
            return this.year * 12 * 28 + this.month * 28 + this.day;
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();   // 파기해야할 개인정보 번호를 담을 리스트
        Date todayDate = new Date(today);   // 오늘 날짜 객체

        // 유효기간 저장
        Map<String, Integer> termMap = new HashMap<>(); // 유효기간을 담을 map {종류=기간}
        for (String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        // 수집된 개인정보 탐색
        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            Date privacyDate = new Date(arr[0]);    // 수집된 날짜 객체

            // 약관 종류에 따라 파기 날짜 계산
            int deadline = privacyDate.getDayInDate() + termMap.get(arr[1]) * 28;

            // 파기 날짜보다 현재 날짜가 같거나 크면 개인정보 파기
            if (deadline <= todayDate.getDayInDate()) {
                result.add(i + 1);
            }
        }

        // List를 Array로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
