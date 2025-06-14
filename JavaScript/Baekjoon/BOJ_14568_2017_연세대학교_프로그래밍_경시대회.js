const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();
const N = Number(input);

let answer = 0;

for (let A = 0; A <= N; A++) {
  for (let B = 0; B <= N; B++) {
    for (let C = 0; C <= N; C++) {
      if (A + B + C === N) {
        if (A >= B + 2) {
          if (A !== 0 && B !== 0 && C !== 0) {
            if (C % 2 === 0) {
              answer++;
            }
          }
        }
      }
    }
  }
}

console.log(answer);
