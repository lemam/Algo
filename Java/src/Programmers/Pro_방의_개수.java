package Programmers;

import java.util.*;

class Pro_방의_개수 {
    class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return row == point.row && col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public int solution(int[] arrows) {
        // arrows 방향 델타 배열
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        // 방문 여부를 저장할 HashMap
        // key = 시작 Point의 hashcode, value = 연결된 Point들의 hashcode
        Map<Point, List<Point>> visited = new HashMap<>();

        Point curr = new Point(0, 0);  // 현재 좌표
        visited.put(curr, new ArrayList<>());
        int answer = 0; // 방의 개수

        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) {  // 교차점 처리를 위한 스케일업
                Point next = new Point(curr.row + dr[arrow], curr.col + dc[arrow]);

                // 처음 방문하는 점인 경우
                if (!visited.containsKey(next)) {
                    // next 좌표와 curr 좌표에 서로 간선 연결
                    visited.put(next, makeEdgeList(curr));
                    visited.get(curr).add(next);
                }
                // 이전에 방문했던 적이 있던 점인 경우
                else {
                    // next 좌표가 curr 좌표와 연결된 적이 없다면
                    if (!visited.get(next).contains(curr)) {
                        // next 좌표와 curr 좌표에 서로 간선 연결
                        visited.get(next).add(curr);
                        visited.get(curr).add(next);
                        answer++;   // 방 하나 생성
                    }
                }

                // 다음 좌표로 이동
                curr = next;
            }
        }

        return answer;
    }

    // Point 객체인 point를 담은 ArrayList를 반환한다.
    private List<Point> makeEdgeList(Point point) {
        List<Point> edge = new ArrayList<>();
        edge.add(point);
        return edge;
    }
}
