package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 2789번 - 특별한 서빙 (골드 5)
 * 
 * NLCS Jeju에서는 파묻튀(파마산을 묻혀 튀긴 소고기)를 서빙하는 것을 좋아한다.
 * 그러나, 학생들은 파묻튀보다는 신선한 가지를 먹고 싶어한다!
 * 
 * 급식실에 N명의 학생들이 차례로 서 있다. 
 * 줄의 앞에서부터 i번째 학생이 가지 대신 파묻튀를 받았을 경우
 * x_i만큼 불만도가 늘어나고, 
 * 가지를 받았을 경우에는 x_i만큼 불만도가 내려간다. 
 * 단, 불만도의 초깃값은 0이다.
 * 
 * 음식을 앞에 서있는 학생부터 순서대로 서빙할 때, 
 * 어떤 한 순간이라도 불만도가 M 이상이 되면 학생들은 ‘가지 운동’을 일으키게 된다.
 * 
 * 가지 운동을 일으키지 않게 하기 위한 가지의 최소 개수를 구하는 프로그램을 작성하시오.
 */

public class BOJ_27896_특별한_서빙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());	// 학생 수
		int M = Integer.parseInt(st.nextToken());	// 불만도 최댓값
		
		// 내림차순 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		int sum = 0;	// 불만도 총합
		int answer = 0;	// 가지 운동을 일으키지 않게 하기 위한 가지의 최소 개수
		
		st = new StringTokenizer(br.readLine());
		
		// 불만도를 오름차순으로 정렬하여 pq에 저장한다.
		for (int i = 0; i < N; i++) {
			int xi = Integer.parseInt(st.nextToken());	// i번째 학생의 불만도
			
			pq.add(xi);
			sum += xi;
			
			// 불만도가 M 이상이면 가장 큰 불만도 값을 가진 학생에게 가지를 준다.
			// 가지를 받은 경우에는 그 값만큼 불만도가 내려간다.
			if (sum >= M) {
				sum -= pq.poll() * 2;
				answer++;
			}
		}
		
		System.out.println(answer);
		
		br.close();
	}
}
