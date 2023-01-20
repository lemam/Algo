function solution(dot) {
  let [x, y] = dot;
  let isEven = x * y > 0;

  return x > 0 ? (isEven ? 1 : 4) : isEven ? 3 : 2;
}
