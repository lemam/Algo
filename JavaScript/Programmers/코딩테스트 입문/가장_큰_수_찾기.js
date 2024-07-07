const array = [9, 10, 11, 8];

console.log(solution(array));

function solution(array) {
  let max = Math.max(...array);
  return [max, array.indexOf(max)];
}
