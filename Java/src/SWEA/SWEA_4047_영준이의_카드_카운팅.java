package SWEA;/*
 * SWEA 4047번 - 영준이의 카드 카운팅 (D3)
 * 
 * 영준이가 하는 카드 게임에는 한 덱의 카드가 필요한데
 * 여기서 얘기하는 “한 덱”이란 스페이드, 다이아몬드, 하트, 클로버 무늬 별로 
 * 각각 A, 2~10, J, Q, K의 라벨 즉 4개의 무늬 별로 각각 13장씩 총 52장의 카드가 있는 모음을 의미한다.
 * 
 * 편의상 A는 1, J, Q, K는 11, 12, 13으로 하여 1~13의 숫자가 카드에 적혀있다고 하자.
 * 
 * 영준이는 몇 장의 카드를 이미 가지고 있는데 게임을 하기 위해서 몇 장의 카드가 더 필요한지 알고 싶어 한다.
 * 그리고 이미 겹치는 카드를 가지고 있다면 오류를 출력하고자 한다.
 * 지금 가지고 있는 카드의 정보가 주어지면 이 작업을 수행하는 프로그램을 작성하라.
 * 
 * 카드에 대한 정보 S
 * S는 각각 3자리로 표현되는 카드들의 정보를 붙여서 만든 하나의 문자열인데 각 카드는 TXY 꼴로 표현
 * T는 카드의 무늬(S, D, H, C)
 * XY는 카드의 숫자 (01 ~ 13)
 * 
 * 문자열 S를 보고 지금 무늬 별로(S, D, H, C 순서로) 몇 장의 카드가 부족한지 출력하여라.
 * 이미 겹치는 카드가 있다면 문자열 “ERROR” (쌍따옴표는 출력하지 않는다)를 출력한다
 */

import java.util.Scanner;

public class SWEA_4047_영준이의_카드_카운팅 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스
        int N = 13; // 무늬 별 카드의 개수
 
        for (int tc = 1; tc <= T; tc++) {
            // 스페이드, 다이아몬드, 하트, 클로버 카드 마킹 배열
            boolean[] S = new boolean[N + 1];
            boolean[] D = new boolean[N + 1];
            boolean[] H = new boolean[N + 1];
            boolean[] C = new boolean[N + 1];
 
            // 부족한 스페이드, 다이아몬드, 하트, 클로버 카드 개수
            int sCnt = N;
            int dCnt = N;
            int hCnt = N;
            int cCnt = N;
            boolean isError = false;
 
            String input = sc.next();
            int len = input.length();
 
            // 3글자씩 읽기
            for (int i = 0; i < len; i += 3) {
                char suit = input.charAt(i); // 카드 무늬
                int number = Integer.parseInt(input.substring(i + 1, i + 3)); // 숫자
 
                // 해당 카드를 마킹한다. 이미 겹치는 카드가 있다면 isError를 true로 한다.
                switch (suit) {
                case 'S':
                    if (S[number]) {
                        isError = true;
                    } else {
                        S[number] = true;
                        sCnt--;
                    }
                    break;
                case 'D':
                    if (D[number]) {
                        isError = true;
                    } else {
                        D[number] = true;
                        dCnt--;
                    }
                    break;
                case 'H':
                    if (H[number]) {
                        isError = true;
                    } else {
                        H[number] = true;
                        hCnt--;
                    }
                    break;
                case 'C':
                    if (C[number]) {
                        isError = true;
                    } else {
                        C[number] = true;
                        cCnt--;
                    }
                    break;
                default:
                    break;
                }
 
                if (isError) break;
            }
 
            System.out.print("#" + tc + " ");
 
            if (isError)
                System.out.println("ERROR");
            else
                System.out.printf("%d %d %d %d\n", sCnt, dCnt, hCnt, cCnt);
        }
 
        sc.close();
    }
}
