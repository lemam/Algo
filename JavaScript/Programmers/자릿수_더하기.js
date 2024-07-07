function solution(n) {
  return n
    .toString()
    .split("")
    .reduce((acc, curr) => acc + Number(curr), 0);
}
