function solution(dots) {
  const arr = [
    [0, 1, 2, 3],
    [0, 2, 1, 3],
    [0, 3, 1, 2],
  ];

  for (const dir of arr) {
    const slope1 = getSlope(dots[dir[0]][0], dots[dir[0]][1], dots[dir[1]][0], dots[dir[1]][1]);
    const slope2 = getSlope(dots[dir[2]][0], dots[dir[2]][1], dots[dir[3]][0], dots[dir[3]][1]);

    if (slope1 == slope2) return 1;
  }

  return 0;
}

function getSlope(x1, y1, x2, y2) {
  return Math.abs(y1 - y2) / Math.abs(x1 - x2);
}
