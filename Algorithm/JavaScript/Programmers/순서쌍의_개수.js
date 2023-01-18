function solution(n) {
  let div = [];

  for (let i = 0; i <= Math.sqrt(n); i++) {
    if (n % i === 0) {
      div.push(i);
      if (n / i != i) div.push(n / i);
    }
  }

  return div.length;
}
