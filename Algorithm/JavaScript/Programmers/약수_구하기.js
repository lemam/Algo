function solution(n) {
  let answer = [];
  let num = Math.sqrt(n);

  for (let i = 1; i <= num; i++) {
    if (n % i === 0) {
      answer.push(i);
      if (num !== i) answer.push(n / i);
    }
  }

  return answer.sort((a, b) => a - b);
}
