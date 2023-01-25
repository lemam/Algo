function solution(n) {
  var answer = 0;
  let sieve = new Array(n + 1).fill(0);

  for (let i = 2; i <= n; i++) {
    if (sieve[i] == 1) continue;

    for (let j = 2 * i; j <= n; j += i) {
      sieve[j] = 1;
    }
  }

  for (let i = 4; i < sieve.length; i++) {
    if (sieve[i] == 1) {
      answer++;
    }
  }

  return answer;
}
