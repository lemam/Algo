package Programmers;

import java.util.*;

class Pro_구명보트 {
    public int solution(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int answer = 0; // 구명보트 개수의 최솟값

        Arrays.sort(people);    // 몸무게를 오름차순으로 정렬

        // left와 right의 몸무게를 합쳤을 때 무게 제한을 초과하면 right인 사람만 태우고,
        // 아니라면 left와 right인 사람을 태운다.
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }
}
