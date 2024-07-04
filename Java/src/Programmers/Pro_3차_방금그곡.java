package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro_3차_방금그곡 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;  // 최대 재생 시간

        // musicinfos 순회
        for (String info : musicinfos) {
            String[] memory = getSheetMusic(m); // 네오가 기억하는 멜로디 음 배열

            String[] infoArr = info.split(",");
            String[] sheet = getSheetMusic(infoArr[3]); // 주어진 악보의 음 배열
            int playTime = getMusicTime(infoArr[1]) - getMusicTime(infoArr[0]); // 음악 재생 시간
            List<String> music = new ArrayList<>(Arrays.asList(sheet)); // 음악의 음 배열

            // 1. 음악 길이가 재생 길이보다 짧은 경우 - 처음부터 재생 시간만큼 반복 재생
            if (sheet.length < playTime) {
                for (int i = 0; i < playTime - sheet.length; i++) {
                    music.add(sheet[i % sheet.length]);
                }
            }
            // 2. 음악 길이가 재생 길이보다 긴 경우 - 처음부터 재생 시간만큼만 재생
            else if (sheet.length > playTime) {
                music = music.subList(0, playTime);
            }

            // 3. 네오가 기억한 멜로디가 포함되어 있는지 확인
            int diff = music.size() - memory.length + 1;

            for (int i = 0; i < diff; i++) {
                if (music.get(i).equals(memory[0])) {
                    boolean flag = true;

                    // 한 글자씩 대조한다.
                    for (int j = 1; j < memory.length; j++) {
                        if (!music.get(i + j).equals(memory[j])) {
                            flag = false;
                            break;
                        }
                    }

                    // 포함되어 있을 경우
                    if (flag) {
                        // 재생 길이가 maxPlayTime보다 크면 갱신
                        if (maxPlayTime < playTime) {
                            answer = infoArr[2];
                            maxPlayTime = playTime;
                        }

                        break;
                    }
                }
            }
        }

        return answer;
    }

    private int getMusicTime(String time) {
        String[] timeArr = time.split(":");

        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }

    private String[] getSheetMusic(String music) {
        List<String> list = new ArrayList<>();
        int mLength = music.length();

        for (int i = 0; i < mLength; i++) {
            // 다음 문자가 #이면 같이 저장
            if (i + 1 < mLength && music.charAt(i + 1) == '#') {
                list.add(music.substring(i, i + 2));
                i++;
            }
            // 아니라면 현재 문자만 저장
            else {
                list.add(music.substring(i, i + 1));
            }
        }

        return list.toArray(new String[0]);
    }
}
