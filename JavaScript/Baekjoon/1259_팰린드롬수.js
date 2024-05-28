let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

for (let t = 0; t < input.length; t++) {
  if (input[t] === "0") break;

  let number = input[t];
  let flag = true;

  for (let i = 0; i < number.length / 2; i++) {
    if (number[i] !== number[number.length - 1 - i]) {
      flag = false;
      break;
    }
  }

  if (flag) console.log("yes");
  else console.log("no");
}
