package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_30805_사전_순_최대_공통_부분_수열 {
    private static class Num implements Comparable<Num> {
        int value, idx;

        public Num(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        // 숫자를 내림차 순으로
        // 같다면 인덱스 오름차순으로
        @Override
        public int compareTo(Num o) {
            if (this.value == o.value)
                return this.idx - o.idx;

            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   // 수열 A의 길이
        int[] A = new int[N];

        // 수열 A 입력
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());   // 수열 B의 길이
        int[] B = new int[M];

        // 수열 B 입력
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 값이 더 큰 것 대로, 같다면 인덱스가 더 앞인 것으로
        // A 수열의 최대값 순으로 우선순위큐에 저장
        PriorityQueue<Num> Apq = new PriorityQueue<>();

        // B 수열의 최댓값 순으로 우선순위큐에 저장
        PriorityQueue<Num> Bpq = new PriorityQueue<>();

        // 큰 값 순으로 정렬해서 Apq에 담음
        for (int i = 0; i < N; i++) {
            Apq.add(new Num(A[i], i));
        }

        int start = 0;      // B 배열에서 탐색 시작 위치
        int limitIdx = -1;  // 이미 선택된 A 값들의 인덱스보다 앞선 값은 무시하기 위한 기준

        // A의 큰 값부터 B에서 순차적으로 대응되는 값 찾기
        while (!Apq.isEmpty()) {
            Num nextMax = Apq.poll();

            for (int i = start; i < M; i++) {
                // 다음 큰 값이 B[i] 와 같고, 이전 선택된 최댓값의 인덱스 값보다 크다면
                if (nextMax.value == B[i] && limitIdx < nextMax.idx) {
                    Bpq.add(new Num(nextMax.value, i));

                    start = i + 1; // 탐색 범위를 다음으로 지정
                    limitIdx = nextMax.idx; // 큰 값의 인덱스를 현재 맥스값으로 갱신
                    break;
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        sb.append(Bpq.size()).append("\n");     // 정답 수열의 크기

        // 정답 수열의 원소 값
        while (!Bpq.isEmpty()) {
            sb.append(Bpq.poll().value).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}