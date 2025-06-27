package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1043_거짓말 {
    private static int[] parents;
    private static List<Integer> truthList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 사람의 수
        int M = Integer.parseInt(st.nextToken());   // 파티의 수
        parents = new int[N + 1];  // union 배열

        // parent 초기화
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truth = Integer.parseInt(st.nextToken());   // 진실을 아는 사람 수
        truthList = new ArrayList<>();    // 진실을 아는 사람의 번호 리스트

        // 진실을 아는 사람이 없으면 모든 파티에서 과장된 이야기를 할 수 있다.
        if (truth == 0) {
            System.out.println(M);
            br.close();
            return;
        }

        // truthList 입력
        for (int i = 0; i < truth; i++) {
            truthList.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyList = new ArrayList[M];   // [파티 번호][i] = 참가한 사람 번호들

        // partyList 초기화
        for (int i = 0; i < M; i++) {
            partyList[i] = new ArrayList<>();
        }

        // partyList 입력
        // 진실을 아는 사람과 연결된 모든 사람을 한 그룹에 묶기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());   // 파티에 참가하는 사람 수
            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);

            for (int j = 1; j < partySize; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[i].add(y);
            }
        }

        int cnt = 0;    // 과장된 이야기를 한 횟수

        // 과장된 이야기가 가능한 파티가 있는지 확인
        for (int i = 0; i < M; i++) {
            boolean flag = true;

            for (int num : partyList[i]) {
                // 파티 구성원 중 진실을 아는 사람이 있다면 불가능
                if (truthList.contains(find(parents[num]))) {
                    flag = false;
                    break;
                }
            }

            if (flag) cnt++;
        }

        System.out.println(cnt);

        br.close();
    }

    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        // y가 진실을 아는 사람의 루트와 연결되어 있다면
        // 진실을 아는 쪽으로 병합하도록 서로의 값을 바꾼다.
        if (truthList.contains(ry)) {
            int temp = rx;
            rx = ry;
            ry = temp;
        }

        // ry가 rx로 병합
        parents[ry] = rx;
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }
}

