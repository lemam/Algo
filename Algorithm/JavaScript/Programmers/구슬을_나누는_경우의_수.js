function solution(balls, share) {
  let n = 1;
  let d = 1;

  for (let i = 0; i < share; i++) {
    n *= balls - i;
    d *= share - i;
  }

  return n / d;
}
