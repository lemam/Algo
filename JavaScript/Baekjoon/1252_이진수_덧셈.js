const readline = require("readline");
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

let input = [];

rl.on("line", function (line) {
  input = line
    .toString()
    .split(" ")
    .map(el => el.split("").reverse());
}).on("close", function () {
  let answer = "";
  let longer, shorter;
  let carry = 0;

  if (input[0].length >= input[1].length) {
    longer = input[0];
    shorter = input[1];
  } else {
    longer = input[1];
    shorter = input[0];
  }

  for (let i = 0; i < longer.length; i++) {
    if (shorter[i] === undefined) shorter[i] = "0";

    let sum = Number(longer[i]) + Number(shorter[i]) + carry;
    let num = parseInt(sum % 2);
    carry = parseInt(sum / 2);
    answer = num + answer;
  }

  if (carry === 1) {
    answer = carry + answer;
  }

  let idx = answer.indexOf("1");
  console.log(answer.slice(idx));
  process.exit();
});
