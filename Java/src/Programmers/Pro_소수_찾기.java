package Programmers;

import java.util.*;

class Pro_소수_찾기 {
    private Set<Integer> set;

    public int solution(String numbers) {
        set = new HashSet<>();  // 모든 숫자 조합을 저장할 HashSet
        int answer = 0; // 소수의 개수

        // 1. 숫자를 이용한 모든 조합을 HashSet에 저장한다.
        permutation(0, "", numbers.toCharArray(), new boolean[numbers.length()]);

        // 2. HashSet의 숫자 조합 중에 소수가 있는지 판별한다.
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 소수를 판별한다.
    private boolean isPrime(int num) {
        if (num < 2) return false;

        // 에라토스테네스의 체
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // 숫자 조합을 HashSet에 저장한다.
    private void permutation(int depth, String result, char[] arr, boolean[] visited) {
        if (depth == arr.length) return;

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;

            String next = result + arr[i];
            set.add(Integer.parseInt(next));

            visited[i] = true;
            permutation(depth + 1, next, arr, visited);
            visited[i] = false;
        }
    }
}