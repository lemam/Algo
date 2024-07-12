function solution(keyinput, board) {
  let x = 0;
  let y = 0;
  const maxX = (board[0] - 1) / 2;
  const maxY = (board[1] - 1) / 2;

  for (const key of keyinput) {
    switch (key) {
      case "up":
        y = Math.min(y + 1, maxY);
        break;
      case "down":
        y = Math.max(y - 1, maxY * -1);
        break;
      case "left":
        x = Math.max(x - 1, maxX * -1);
        break;
      case "right":
        x = Math.min(x + 1, maxX);
        break;
    }
  }

  return [x, y];
}
