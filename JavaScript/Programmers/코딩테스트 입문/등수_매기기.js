function solution(score) {
  const avg = score.map(x => (x[0] + x[1]) / 2);
  let sorted = avg.slice().sort((a, b) => b - a);

  return avg.map(x => sorted.indexOf(x) + 1);
}
