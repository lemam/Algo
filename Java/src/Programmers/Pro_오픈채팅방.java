package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro_오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();  // 유저 정보를 담은 맵 : {아이디=닉네임}
        List<String[]> outputList = new ArrayList<>();  // 출력할 정보를 저장할 리스트 : [명령어, 아이디]

        for (String line : record) {
            String[] info = line.split(" ");    // [명령어, 아이디, 닉네임]

            switch (info[0]) {
                case "Enter":
                    userMap.put(info[1], info[2]);  // 입장한 유저의 정보 저장
                    outputList.add(new String[]{info[0], info[1]});
                    break;
                case "Leave":
                    outputList.add(new String[]{info[0], info[1]});
                    break;
                case "Change":
                    userMap.put(info[1], info[2]);  // 유저 닉네임 수정
                    break;
            }
        }

        String[] answer = new String[outputList.size()];

        for (int i = 0; i < answer.length; i++) {
            String[] output = outputList.get(i);    // [명령어, 아이디]

            switch (output[0]) {
                case "Enter":
                    answer[i] = userMap.get(output[1]) + "님이 들어왔습니다.";
                    break;
                case "Leave":
                    answer[i] = userMap.get(output[1]) + "님이 나갔습니다.";
                    break;
            }
        }

        return answer;
    }
}
