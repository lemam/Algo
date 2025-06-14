const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();
const N = Number(input);

let answer = 0;

for (let A = 1; A <= N - 2; A++) {
  for (let B = A + 2; B <= N - 2 - A; B++) {
    let C = N - (A + B);
    if (C > 0 && C % 2 === 0) {
      answer++;
    }
  }
}

console.log(answer);
