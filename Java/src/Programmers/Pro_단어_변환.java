package Programmers;

import java.util.*;

class Pro_단어_변환 {
    public int solution(String begin, String target, String[] words) {
        // 1. words에 target이 없다면 0을 반환한다.
        if (!Arrays.asList(words).contains(target)) return 0;

        // 2. BFS
        Queue<String[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new String[]{begin, "0"});

        while (!queue.isEmpty()) {
            String[] now = queue.poll();

            // target이면 변환 횟수를 반환한다.
            if (now[0].equals(target)) return Integer.parseInt(now[1]);

            for (int i = 0; i < words.length; i++) {
                // now와 알파벳 차이가 1개인 단어 && 방문한 적 없는 단어
                if (getWordDiff(now[0], words[i]) == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new String[]{words[i], Integer.parseInt(now[1]) + 1 + ""});
                }
            }
        }

        return 0;
    }

    private int getWordDiff(String str1, String str2) {
        String[] arr1 = str1.split("");
        String[] arr2 = str2.split("");
        int diff = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                diff++;
            }
        }

        return diff;
    }
}
