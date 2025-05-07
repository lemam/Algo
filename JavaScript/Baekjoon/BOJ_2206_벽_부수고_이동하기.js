class Queue {
  constructor() {
    this.data = [];
    this.head = 0;
    this.tail = 0;
  }

  push(item) {
    this.data[this.tail++] = item;
  }

  shift() {
    return this.data[this.head++];
  }

  isEmpty() {
    return this.head === this.tail;
  }
}

const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const map = input.slice(1).map((el) => el.split('').map(Number));
const visited = Array.from({ length: N }, () =>
  Array.from({ length: M }, () => Array(2).fill(false))
); // [row][col][isCrashed] : 벽을 부순 경우를 구분하여 방문 체크

// const queue = [];
const queue = new Queue();

// 시작 칸을 이동거리에 포함하므로 dist = 1
// isCrashed = 0 : 아직 벽을 부수지 않은 상태
queue.push({ row: 0, col: 0, dist: 1, isCrashed: 0 });
visited[0][0][0] = true;

// 12 3 6 9
const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

// BFS 수행
while (!queue.isEmpty()) {
  const { row, col, dist, isCrashed } = queue.shift();

  // 끝나는 칸에 도착한 경우 최단 거리 출력
  if (row === N - 1 && col === M - 1) {
    console.log(dist);
    return;
  }

  // 4방 탐색
  for (let i = 0; i < 4; i++) {
    const nr = row + dr[i];
    const nc = col + dc[i];

    // 다음 이동 칸이 범위 밖이거나 이미 방문했던 칸이면 스킵
    if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc][isCrashed])
      continue;

    // 다음 이동 칸이 벽이 아닌 경우
    if (map[nr][nc] === 0) {
      visited[nr][nc][isCrashed] = true;
      queue.push({ row: nr, col: nc, dist: dist + 1, isCrashed });
    }
    // 다음 이동 칸이 벽이고, 벽을 부술 수 있는 기회가 있는 경우
    else if (map[nr][nc] === 1 && isCrashed === 0) {
      visited[nr][nc][1] = true;
      queue.push({ row: nr, col: nc, dist: dist + 1, isCrashed: 1 });
    }
  }
}

// 도착 불가능할 경우 -1 출력
console.log(-1);
