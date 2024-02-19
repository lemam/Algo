import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16943_숫자_재배치 {
    private static int B, answer;
    private static int[] arrA;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] temp = st.nextToken().toCharArray();
        B = Integer.parseInt(st.nextToken());

        arrA = new int[temp.length];    // A 자릿수 배열
        visited = new boolean[temp.length];
        answer = -1;

        for (int i = 0; i < temp.length; i++) {
            arrA[i] = temp[i] - '0';
        }

        solution(0, 0, temp.length);

        System.out.println(answer);

        br.close();
    }

    private static void solution(int depth, int num, int N) {
        if (depth == N) {
            answer = Math.max(answer, num);
            return;
        }

        for (int i = 0; i < N; i++) {
            // 이미 방문했거나 첫번째 숫자가 0인 경우 건너뛴다.
            if (visited[i] || (depth == 0 && arrA[i] == 0)) continue;
            // 누적값이 B 이상인 경우 건너뛴다.
            if (num * 10 + arrA[i] >= B) continue;

            visited[i] = true;
            solution(depth + 1, num * 10 + arrA[i], N);
            visited[i] = false;
        }
    }
}
