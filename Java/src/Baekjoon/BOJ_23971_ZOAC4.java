package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_23971_ZOAC4 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream(new File("C:\\Users\\OWNER\\Desktop\\Algo\\Java\\src\\input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());   // 테이블 행
        int W = Integer.parseInt(st.nextToken());   // 테이블 열
        int N = Integer.parseInt(st.nextToken());   // 거리두기 세로 거리
        int M = Integer.parseInt(st.nextToken());   // 거리두기 가로 거리

        // (처음 한 명을 제외한 자리 개수 / 거리두기에 필요한 테이블 수) + 처음 앉은 한 명
        // Math.ceil() 사용하는 방법도 있지만 이게 제일 깔끔하다.
        int r = (H - 1) / (N + 1) + 1;  // 세로로 앉을 수 있는 사람의 수
        int c = (W - 1) / (M + 1) + 1;  // 가로로 앉을 수 있는 사람의 수

        System.out.println(r * c);

        br.close();
    }
}

