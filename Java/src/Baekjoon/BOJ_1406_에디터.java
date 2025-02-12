package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split("");
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>(Arrays.asList(str));
        ListIterator<String> iter = list.listIterator();

        // 커서(iter)를 맨 뒤로 이동
        while (iter.hasNext()) {
            iter.next();
        }

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "L":
                    if (iter.hasPrevious())
                        iter.previous();

                    break;
                case "D":
                    if (iter.hasNext())
                        iter.next();

                    break;
                case "B":
                    // remove()는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거함
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P":
                    iter.add(command[1]);
                    break;
                default:
                    break;
            }
        }

        System.out.println(String.join("", list));

        br.close();
    }
}
