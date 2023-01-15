function solution(numbers) {
  let answer = numbers.reduce((acc, cur) => (acc += cur), 0) / numbers.length;
  return answer;
}
