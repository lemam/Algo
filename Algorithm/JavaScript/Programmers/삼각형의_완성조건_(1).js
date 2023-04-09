function solution(sides) {
  const max = Math.max(...sides);
  const sum = sides.reduce((acc, cur) => acc + cur, 0) - max;

  return max < sum ? 1 : 2;
}
