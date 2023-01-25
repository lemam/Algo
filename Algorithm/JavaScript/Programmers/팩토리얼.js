function solution(n) {
  let num = 1;
  let i = 1;

  for (i = 1; i <= 10; i++) {
    if ((num *= i) >= n) break;
  }

  return num > n ? i - 1 : i;
}
