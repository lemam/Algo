const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

let dices = [];
for (let i = 0; i < input.length; i++) {
  dices[i] = Number(input[i]);
}

let sum = new Array(81);
sum.fill(0);

let cnt = 0;
let result = 0;

for (let i = 1; i <= dices[0]; i++) {
  for (let j = 1; j <= dices[1]; j++) {
    for (let k = 1; k <= dices[2]; k++) {
      sum[i + j + k] += 1;
    }
  }
}

for (let i = 1; i < sum.length; i++) {
  if (cnt < sum[i]) {
    cnt = sum[i];
    result = i;
  }
}

console.log(result);
