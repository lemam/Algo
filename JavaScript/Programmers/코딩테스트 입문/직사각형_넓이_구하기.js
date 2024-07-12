function solution(dots) {
  let width, height;

  // 가로 길이 구하기
  for (let i = 1; i < 4; i++) {
    const diff = dots[0][0] - dots[i][0];
    if (diff !== 0) width = Math.abs(diff);
  }

  // 세로 길이 구하기
  for (let i = 1; i < 4; i++) {
    const diff = dots[0][1] - dots[i][1];
    if (diff !== 0) height = Math.abs(diff);
  }

  return width * height;
}
