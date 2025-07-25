package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1991_트리_순회 {
    private static class Node {
        char value, left, right;

        public Node(char value, char left, char right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());    // 노드의 개수
        Node[] tree = new Node[N];

        // tree 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node - 'A'] = new Node(node, left, right);
        }

        sb = new StringBuilder();

        // 전위 순회
        preorder(0, tree);
        sb.append("\n");

        // 중위 순회
        inorder(0, tree);
        sb.append("\n");

        // 후위 순회
        postorder(0, tree);

        // 출력
        System.out.println(sb);

        br.close();
    }

    private static void postorder(int idx, Node[] tree) {
        // 왼쪽으로 이동하기
        if (tree[idx].left != '.')
            postorder(tree[idx].left - 'A', tree);

        // 오른쪽으로 이동하기
        if (tree[idx].right != '.')
            postorder(tree[idx].right - 'A', tree);

        // 노드 출력하기
        sb.append(tree[idx].value);
    }

    private static void inorder(int idx, Node[] tree) {
        // 왼쪽으로 이동하기
        if (tree[idx].left != '.')
            inorder(tree[idx].left - 'A', tree);

        // 노드 출력하기
        sb.append(tree[idx].value);

        // 오른쪽으로 이동하기
        if (tree[idx].right != '.')
            inorder(tree[idx].right - 'A', tree);
    }

    private static void preorder(int idx, Node[] tree) {
        // 노드 출력하기
        sb.append(tree[idx].value);

        // 왼쪽으로 이동하기
        if (tree[idx].left != '.')
            preorder(tree[idx].left - 'A', tree);

        // 오른쪽으로 이동하기
        if (tree[idx].right != '.')
            preorder(tree[idx].right - 'A', tree);
    }
}