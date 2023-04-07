function solution(my_string) {
  return [...my_string]
    .filter(v => !isNaN(v))
    .map(x => Number(x))
    .reduce((prev, curr) => (prev += curr));
}
