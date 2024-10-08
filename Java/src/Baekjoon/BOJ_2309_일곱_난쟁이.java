package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 백준 2309번 - 일곱 난쟁이 (브론즈 1)
 * 
 * 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 
 * 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
 * 
 * 아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다.
 * 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
 * 
 * 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 * 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
 * 
 * 일곱 난쟁이의 키를 오름차순으로 출력한다. 
 * 일곱 난쟁이를 찾을 수 없는 경우는 없다.
 */

public class BOJ_2309_일곱_난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 9;
		int[] arr = new int[N]; // 난쟁이 키 배열 입력
		
		int sum = 0;

		// 키 배열 입력
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		// i, j를 뺐을 때 키의 총합이 100이 되는지 확인
		loop: for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break loop;
				}
			}
		}
		
		// 오름차순 정렬
		Arrays.sort(arr);
		
		for (int n : arr) {
			if (n > 0) {
				System.out.println(n);
			}
		}

		br.close();
	}
}
