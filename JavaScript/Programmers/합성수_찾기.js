function solution(n) {
  let base = Array.from(Array(n), (_, i) => i + 1);

  for (let i = 2; i <= Math.floor(Math.sqrt(n)); i++) {
    base = base.filter(el => el % i != 0 || el <= i);
  }

  return n - base.length;
}
