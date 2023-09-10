/*
 * 백준 10815번 - 숫자 카드 (실버 5)
 * 
 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 
 * 상근이는 숫자 카드 N개를 가지고 있다. 
 * 
 * 정수 M개가 주어졌을 때, 
 * 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 
 * 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 
 * 아니면 0을 공백으로 구분해 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_10815_숫자_카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 숫자 카드의 개수

		HashSet<Integer> set = new HashSet<Integer>(); // 숫자 카드에 적혀 있는 정수를 저장하는 set
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숫자 카드에 적혀 있는 정수 입력
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		int M = Integer.parseInt(br.readLine()); // 검사할 숫자의 개수

		st = new StringTokenizer(br.readLine());
		
		// 상근이가 가지고 있는 숫자 카드인지 아닌지 검사
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (set.contains(num)) bw.write("1 ");
			else bw.write("0 ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
