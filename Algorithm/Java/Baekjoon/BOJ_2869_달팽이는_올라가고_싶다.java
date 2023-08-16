import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 백준 2869번 - 달팽이는 올라가고 싶다 (브론즈 1)
 * 
 * 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
 * 
 * 달팽이는 낮에 A미터 올라갈 수 있다.
 * 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 
 * 또, 정상에 올라간 후에는 미끄러지지 않는다.
 * 
 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 */

public class BOJ_2869_달팽이는_올라가고_싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); // 낮에 올라가는 높이
		int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러지는 높이
		int V = Integer.parseInt(st.nextToken()); // 나무 막대의 높이

		if (A >= V) {
			System.out.println(1);
		} else {
			double diff = V - A; // 한 번 이동하고 남은 거리
			int days = (int) Math.ceil(diff / (A - B)); // diff 이상으로 올라가는 데 걸리는 일수
			
			// diff 이동한 날 포함 출력
			System.out.println(days + 1);
		}

		br.close();
	}
}
