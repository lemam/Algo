// param {Number} n
// return {Array<Number>} n의 약수를 오름차순으로 담은 배열

// example
// n      = 24
// result = [1, 2, 3, 4, 6, 8, 12, 24]

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
