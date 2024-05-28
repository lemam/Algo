package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_15552_빠른_AB {
	public static void main(String[] args) throws IOException {
//		테스트케이스 T
//		(T는 최대 1,000,000)
//	
//		두 정수 A와 B
//		(A와 B는 1 이상, 1,000 이하)
//		
//		각 테스트케이스마다 A + B를 한 줄에 하나씩 순서대로 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			bw.write((A + B) + "\n");
		}
		
		br.close();
		
		bw.flush();
		bw.close();
	}
}
