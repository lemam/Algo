package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_20006_랭킹전_대기열 {
    private static class Player {
        int level;
        String nickname;

        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return this.level + " " + this.nickname;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());   // 플레이어 수
        int m = Integer.parseInt(st.nextToken());   // 방의 정원
        ArrayList<ArrayList<Player>> rooms = new ArrayList<>(); // 방 리스트

        // 플레이어 매칭 수행
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());   // 플레이어 레벨
            String n = st.nextToken();                  // 플레이어 닉네임
            Player player = new Player(l, n);           // 플레이어 정보 배열

            // 매칭이 가능한 방이 없는 경우
            // 새로운 방을 생성하고 플레이어를 입장시킨다.
            if (rooms.isEmpty()) {
                ArrayList<Player> room = new ArrayList<>();
                room.add(player);
                rooms.add(room);
                continue;
            }

            // 입장 가능한 방이 있는 경우
            boolean isEntered = false;   // 플레이어의 방 입장 여부

            // 방을 순회하면서 정원이 차지 않은 방을 찾는다.
            for (ArrayList<Player> room : rooms) {
                if (room.size() == m) continue;

                int level = room.get(0).level;

                // 방의 첫 입장 플레이어 레벨 기준 -10 ~ +10까지 입장이 가능하다.
                if (Math.abs(l - level) <= 10) {
                    room.add(player);
                    isEntered = true;
                    break;
                }
            }

            // 모든 방에 입장하지 못했다면 새로운 방을 추가한다.
            if (!isEntered) {
                ArrayList<Player> room = new ArrayList<>();
                room.add(player);
                rooms.add(room);
            }
        }


        // 방 정보 출력
        StringBuilder sb = new StringBuilder();

        for (ArrayList<Player> room : rooms) {
            // 유저 정보를 닉네임 사전순으로 정렬한다.
            room.sort(new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.nickname.compareTo(o2.nickname);
                }
            });

            // 방 상태 출력
            if (room.size() == m) sb.append("Started!").append("\n");
            else sb.append("Waiting!").append("\n");

            // 플레이어 정보 출력
            for (Player player : room) {
                sb.append(player).append("\n");
            }
        }

        System.out.println(sb);

        br.close();
    }
}
