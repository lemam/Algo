/*
 * 백준 12789번 - 도키도키 간식드리미 (실버 3)
 * 
 * 인하대학교 학생회에서는 중간, 기말고사 때마다 시험 공부에 지친 학우들을 위해 간식을 나눠주는 간식 드리미 행사를 실시한다.
 * 승환이는 마지막 번호표를 받게 되었다.
 * 승환이는 모든 사람들이 순서대로 간식을 받을 수 있는지 확인하는 프로그램을 만들기로 했다.
 * 
 * 사람들은 현재 1열로 줄을 서있고, 맨 앞의 사람만 이동이 가능하다.
 * 인규는 번호표 순서대로만 통과할 수 있는 라인을 만들어 두었다.
 * 이 라인과 대기열의 맨 앞 사람 사이에는 한 사람씩 1열이 들어갈 수 있는 공간이 있다.
 * 현재 대기열의 사람들은 이 공간으로 올 수 있지만 반대는 불가능하다.
 * 승환이를 도와 프로그램을 완성하라.
 * 
 * 승환이가 무사히 간식을 받을 수 있으면 "Nice"(따옴표는 제외)를 출력하고 그렇지 않다면 "Sad"(따옴표는 제외)를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_12789_도키도키_간식드리미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 승환이의 앞에 서 있는 학생들의 수
		int[] students = new int[N]; // 승환이 앞에 서 있는 모든 학생들의 번호표 배열
		Stack<Integer> waiting = new Stack<Integer>(); // 대기열(한 사람씩 1열이 들어갈 수 있는 공간)

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 승환이 앞에 서 있는 모든 학생들의 번호표 입력
		for (int i = 0; i < N; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}

		int num = 1; // 간식을 받을 번호
		String answer = "Nice";

		// 번호표 순서대로 간식 받기
		for (int i = 0; i < N; i++) {
			// 현재 학생이 간식을 받을 번호이면 간식을 받는다.
			if (students[i] == num) {
				num++;
				continue;
			}

			// 현재 학생의 번호표가 간식을 받을 번호보다 큰 경우 대기열을 확인한다.
			if (students[i] > num) {
				// 대기열에 맨 앞에 간식을 받을 번호표를 가진 학생이 있으면 대기열에서 나가 간식을 받는다.
				while (!waiting.isEmpty() && waiting.peek() == num) {
					waiting.pop();
					num++;
				}
				
				// 대기열이 비었거나,
				// 현재 학생이 대기열 맨 앞의 학생보다 큰 번호표를 가졌다면 대기열에 넣는다.
				if (waiting.isEmpty() || waiting.peek() > students[i]) {
					waiting.push(students[i]);
				}
				// 아니라면 모두가 순서대로 간식을 받을 수 없다.
				else {
					answer = "Sad";
					break;
				}
			}
		}

		System.out.println(answer);

		br.close();
	}
}
