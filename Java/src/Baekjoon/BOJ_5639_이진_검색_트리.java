package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5639_이진_검색_트리 {
    private static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        public void insert(int n) {
            if (n < this.num) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(st.nextToken())); // 루트 노드 (첫번째 입력)

        while (true) {
            String input = br.readLine();

            // 입력이 없으면 while문 종료
            if (input == null || input.equals("")) break;

            // 루트에서부터 탐색하며 노드 추가
            root.insert(Integer.parseInt(input));
        }

        dfs(root);
        System.out.println(sb);

        br.close();
    }

    // 후위 순회
    private static void dfs(Node node) {
        if (node == null) return;

        dfs(node.left);
        dfs(node.right);
        sb.append(node.num).append("\n");
    }
}
