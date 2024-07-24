function solution(n) {
  let num = 0;

  for (let i = 1; i <= n; i++) {
    num++;
    while (num % 3 === 0 || num.toString().includes("3")) {
      num++;
    }
  }

  return num;
}
