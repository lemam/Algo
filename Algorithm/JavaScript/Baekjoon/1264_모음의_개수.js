let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().toLowerCase().split("\n");

for (let t = 0; t < input.length; t++) {
  if (input[t] === "#") break;

  let str = input[t];
  let cnt = 0;

  for (let i = 0; i < str.length; i++) {
    if (str[i] === "a" || str[i] === "e" || str[i] === "i" || str[i] === "o" || str[i] === "u") {
      cnt++;
    }
  }

  console.log(cnt);
}
