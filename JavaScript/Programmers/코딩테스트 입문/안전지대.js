function solution(board) {
  // T RT R RB B LB L LT
  const dr = [-1, -1, 0, 1, 1, 1, 0, -1];
  const dc = [0, 1, 1, 1, 0, -1, -1, -1];
  const n = board.length;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 1) {
        for (let dir = 0; dir < dr.length; dir++) {
          const nr = i + dr[dir];
          const nc = j + dc[dir];

          if (nr < 0 || nr >= n || nc < 0 || nr >= n || board[nr][nc] === 1) continue;

          board[nr][nc] = 2;
        }
      }
    }
  }

  let answer = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (board[i][j] === 0) answer++;
    }
  }

  return answer;
}
