function solution(box, n) {
  return box.reduce((prev, curr) => prev * Math.floor(curr / n), 1);
}
