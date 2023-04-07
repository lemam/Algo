function solution(n) {
  const set = new Set();
  let num = n;
  let m = 2;

  while (num !== 1) {
    if (num % m) {
      m++;
      continue;
    }

    num /= m;
    set.add(m);
    m = 2;
  }

  let answer = Array.from(set);
  return answer;
}
