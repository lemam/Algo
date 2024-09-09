package Programmers;

import java.util.*;

class Pro_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();    // 장르별 총 재생 횟수
        HashMap<String, HashMap<Integer, Integer>> musicMap = new HashMap<>();  // 각 장르에 속한 노래 정보(고유번호=재생횟수)
        List<Integer> answer = new ArrayList<>();

        // genreMap에 장르별 총 재생 횟수를, musicMap에 노래 정보를 저장한다.
        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                musicMap.get(genres[i]).put(i, plays[i]);
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                musicMap.put(genres[i], map);
                genreMap.put(genres[i], plays[i]);
            }
        }

        // 가장 많이 재생된 장르 순서대로 key를 정렬한다. (value기준 내림차순)
        List<String> genreKey = new ArrayList<>(genreMap.keySet());
        genreKey.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        // 장르별 많이 재생된 노래를 수록한다.
        for (String key : genreKey) {
            HashMap<Integer, Integer> map = musicMap.get(key);
            List<Integer> musicKey = new ArrayList<>(map.keySet());

            // 장르별 많이 재생된 노래 순서대로 key를 정렬한다. (value기준 내림차순)
            musicKey.sort((o1, o2) -> map.get(o2) - map.get(o1));

            // 가장 많이 재생된 2곡을 수록한다.
            // 속한 노래가 1개인 경우 한 곡만 수록한다.
            answer.add(musicKey.get(0));
            if (musicKey.size() > 1)
                answer.add(musicKey.get(1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
