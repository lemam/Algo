package Programmers;

import java.util.*;

class Pro_H_Index {
    /*
    [0, 1, 3, 5, 6]

    해당 논문 인용 횟수 = citations[i]
    해당 논문보다 인용횟수가 크거나 같은 논문 편수 = h
    h회 이상 인용된 논문 편수가 h편 이상이다. (true / false)

    0: h=5 | 5회 이상 인용된 논문 편수가 5편 이상이다. => false
    1: h=4 | 4회 이상 인용된 논문 편수가 4편 이상이다. => false
    3: h=3 | 3회 이상 인용된 논문 편수가 3편 이상이다. => true => 최대값
    5: h=2 | 2회 이상 인용된 논문 편수가 2편 이상이다. => true
    6: h=1 | 1회 이상 인용된 논문 편수가 1편 이상이다. => true
     */

    public static int solution(int[] citations) {
        int answer = 0;

        // 인용 횟수를 내림차순 정렬하면 "나머지 논문이 h번 이하 인용되었다면" 이 조건을 신경쓰지 않아도 됨.
        Arrays.sort(citations);

        for (int i = 0; i < citations.length - 1; i++) {
            int h = citations.length - i;   // citations[i]번 이상 인용된 논문의 개수

            // 현재 논문의 인용 횟수가 h보다 이상을 만족하는 처음이 최대값이다.
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
