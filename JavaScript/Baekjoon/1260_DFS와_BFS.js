const fs = require('fs');
const input = fs
  .readFileSync('/dev/stdin')
  .toString()
  .split('\n')
  .map((el) => el.split(' ').map(Number));

const N = input[0][0]; // 정점의 개수
const M = input[0][1]; // 간선의 개수
const V = input[0][2]; // 탐색을 시작할 정점의 번호
const graph = new Array(N + 1).fill().map((el) => []); // 그래프 배열

// 양방향 간선 입력
for (let i = 1; i <= M; i++) {
  const v1 = input[i][0];
  const v2 = input[i][1];
  graph[v1].push(v2);
  graph[v2].push(v1);
}

// 오름차순 정렬
graph.forEach((el) => el.sort((a, b) => a - b));

// DFS 수행
let result = [];
let visited = new Array(N + 1).fill(false);

dfs(V);
console.log(result.join(' '));

// BFS 수행
result = [];
visited = new Array(N + 1).fill(false);

bfs(V);
console.log(result.join(' '));

function dfs(idx) {
  visited[idx] = true;
  result.push(idx);

  for (const node of graph[idx]) {
    if (visited[node]) continue;
    dfs(node);
  }
}

function bfs(idx) {
  const queue = [];
  queue.push(idx);
  visited[idx] = true;

  while (queue.length > 0) {
    const curr = queue.shift();
    result.push(curr);

    for (const node of graph[curr]) {
      if (visited[node]) continue;
      queue.push(node);
      visited[node] = true;
    }
  }
}
