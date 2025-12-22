package Baekjoon;

import java.io.*;

public class BOJ_31403_ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int AB = Integer.parseInt("" + A + B);

        System.out.println(A + B - C);
        System.out.println(AB - C);

        br.close();
    }
}
