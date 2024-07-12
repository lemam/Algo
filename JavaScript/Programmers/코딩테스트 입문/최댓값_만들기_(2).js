function solution(numbers) {
  let answer = 10000 * -10000;

  for (let i = 0; i < numbers.length - 1; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      answer = Math.max(answer, numbers[i] * numbers[j]);
    }
  }

  return answer;
}
