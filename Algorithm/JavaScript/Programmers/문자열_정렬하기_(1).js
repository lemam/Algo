function solution(my_string) {
  return [...my_string]
    .filter(v => Number.isInteger(v * 1))
    .map(x => Number(x))
    .sort((a, b) => a - b);
}
