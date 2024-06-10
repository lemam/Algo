package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro_주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> entryMap = new HashMap<>();    // 입차 시간을 저장할 맵
        Map<String, Integer> timeMap = new HashMap<>();     // 주차 시간을 저장할 맵
        Map<String, Integer> costMap = new HashMap<>();     // 주차 요금을 저장할 맵

        // 입/출차 기록 탐색
        for (String record : records) {
            String[] info = record.split(" ");
            String[] timeArr = info[0].split(":");

            String number = info[1];    // 차량번호
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);    // 시간

            // 입차 내역인 경우 시간을 저장한다.
            if (info[2].equals("IN")) {
                entryMap.put(number, time);
            }
            // 출차 내역인 경우 주차 시간을 계산하여 저장한다.
            else {
                int entryTime = entryMap.get(number);   // 입차 시간
                int parkingTime = time - entryTime;     // 주자 시간
                int prevParkingTime = timeMap.getOrDefault(number, 0);  // 누적 주차 시간
                timeMap.put(number, prevParkingTime + parkingTime);
                entryMap.remove(number);    // 입차 시간 삭제
            }
        }

        // 아직 출차하지 않은 차들의 오늘치 주차 시간 계산
        for (String key : entryMap.keySet()) {
            int entryTime = entryMap.get(key);
            int parkingTime = (23 * 60 + 59) - entryTime;
            int prevParkingTime = timeMap.getOrDefault(key, 0);
            timeMap.put(key, prevParkingTime + parkingTime);
        }

        // 주차 시간을 요금으로 환산
        for (String key : timeMap.keySet()) {
            double overTime = timeMap.get(key) - fees[0];   // 기본 시간을 초과한 시간
            if (overTime < 0) overTime = 0; // 음수인 경우 0으로 변환 -> 기본 요금만 내기 위해
            int cost = (int) (fees[1] + Math.ceil(overTime / fees[2]) * fees[3]);   // 총 주차 요금
            costMap.put(key, cost);
        }

        // 차량번호 오름차순으로 주차요금을 배열에 저장
        List<String> keyList = new ArrayList<>(costMap.keySet());
        keyList.sort((o1, o2) -> o1.compareTo(o2));

        int[] answer = new int[keyList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = costMap.get(keyList.get(i));
        }

        return answer;
    }
}
