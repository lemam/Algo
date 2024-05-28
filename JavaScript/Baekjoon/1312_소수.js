let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

let A = parseInt(input[0]);
let B = parseInt(input[1]);
let N = parseInt(input[2]);

let decimals = [0];
let mod = A % B;
let T = N;

while (T--) {
  mod += "0";
  decimals.push(parseInt(mod / B));
  mod %= B;
}

console.log(decimals[N]);
