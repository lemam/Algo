let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
let result = "";

for (let i = 0; i < input.length; i++) {
  let N = input[i];
  let sum = 0;

  if (N === "0") break;

  for (let j = 0; j < N.length; j++) {
    let number = N[j];

    if (number === "0") sum += 4;
    else if (number === "1") sum += 2;
    else sum += 3;
  }

  sum += N.length + 1;
  result += sum.toString() + "\n";
}

console.log(result);
