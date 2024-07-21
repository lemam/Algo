package Programmers;

import java.util.*;

class Pro_신고_결과_받기 {
    public class User {
        int id;
        String name;
        List<Integer> reportList;   // 신고한 유저 아이디 리스트
        int reportedCount;  // 신고당한 횟수

        public User(int id, String name) {
            this.id = id;
            this.name = name;
            reportList = new ArrayList<>();
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        User[] users = new User[id_list.length];    // 유저 객체 배열

        // 1. 유저 정보 저장
        for (int i = 0; i < id_list.length; i++) {
            users[i] = new User(i + 1, id_list[i]);
        }

        // 2. 신고한 유저 기록
        for (String info : report) {
            String[] names = info.split(" ");
            List<String> temp = Arrays.asList(id_list);
            int to = temp.indexOf(names[0]);    // 신고자
            int from = temp.indexOf(names[1]);  // 신고대상자

            // 동일한 유저에 대한 중복 신고는 무시한다.
            if (users[to].reportList.contains(from + 1)) continue;

            // 신고 정보 저장
            users[to].reportList.add(from + 1);
            users[from].reportedCount++;
        }

        // 3. 이용 정지된 유저 찾기
        List<Integer> suspendedUserIds = new ArrayList<>(); // 이용 정지된 유저 아이디 리스트

        for (User user : users) {
            // k회 이상 신고를 받은 유저의 아이디를 리스트에 저장
            if (user.reportedCount >= k) {
                suspendedUserIds.add(user.id);
            }
        }

        // 4. 결과 메일 개수 세기
        int[] answer = new int[id_list.length]; // 각 유저가 받은 결과 메일 수 배열

        for (int i = 0; i < answer.length; i++) {
            int count = 0;

            // 신고했던 유저들 중에 정지된 유저가 포함되어 있으면 정지 메일 개수 추가
            for (int id : suspendedUserIds) {
                if (users[i].reportList.contains(id)) {
                    count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
