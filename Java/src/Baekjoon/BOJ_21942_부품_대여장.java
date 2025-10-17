package Baekjoon;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BOJ_21942_부품_대여장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 정보 개수

        // 대여 기간
        String[] durationParts = input[1].split("/");
        long standardMinutes = Duration.ofDays(Integer.parseInt(durationParts[0]))
                .plusHours(Integer.parseInt(durationParts[1].split(":")[0]))
                .plusMinutes(Integer.parseInt(durationParts[1].split(":")[1]))
                .toMinutes();   // 입력받은 대여기간을 분 단위로 변환

        int F = Integer.parseInt(input[2]);  // 벌금

        Map<String, LocalDateTime> rentalLog = new HashMap<>(); // 대여 중인 정보를 저장하는 map
        Map<String, Long> feeLog = new TreeMap<>(); // 회원별 벌금 누적을 저장하는 map

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // 로그 처리 수행
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            String dateTime = parts[0] + " " + parts[1];    // 빌린 시각
            String item = parts[2]; // 부품 이름
            String member = parts[3];   // 닉네임
            String key = member + " " + item;

            // 빌린 시각을 LocalDateTime으로 변환
            LocalDateTime currentTime = LocalDateTime.parse(dateTime, formatter);

            // 이미 대여 기록이 있는 경우 반납한다.
            if (rentalLog.containsKey(key)) {
                LocalDateTime rentalTime = rentalLog.remove(key);
                long minutes = Duration.between(rentalTime, currentTime).toMinutes();   // 대여 시간(분) 계산

                // 대여 기간을 초과한 경우 초과한 시간만큼 벌금을 부여한다.
                if (minutes > standardMinutes) {
                    long fee = (minutes - standardMinutes) * F; // 벌금
                    feeLog.put(member, feeLog.getOrDefault(member, 0L) + fee);  // 기존 벌금에 누적
                }
            }
            // 대여 기록에 없으면 대여를 시작한다.
            else {
                rentalLog.put(key, currentTime);
            }
        }

        // 벌금을 내야하는 사람들이 없는 경우는 -1을 출력
        if (feeLog.isEmpty()) {
            System.out.println(-1);
        }
        // 벌금을 내야하는 사람들을 사전순으로 출력
        else {
            for (Map.Entry<String, Long> entry : feeLog.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }

        br.close();
    }
}