package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10869_사칙연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.printf("%d\n", a + b);
        System.out.printf("%d\n", a - b);
        System.out.printf("%d\n", a * b);
        System.out.printf("%d\n", a / b);
        System.out.printf("%d\n", a % b);

        br.close();
    }
}
