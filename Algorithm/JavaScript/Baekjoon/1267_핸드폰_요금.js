const timeY = 30;
const costY = 10;
const timeM = 60;
const costM = 15;

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];

rl.on("line", function (line) {
  input.push(line);
}).on("close", function () {
  let N = input[0];
  let times = input[1].split(" ");
  let sumY = 0;
  let sumM = 0;

  for (let n = 0; n < N; n++) {
    let time = Number(times[n]);

    if (time >= timeY) sumY += (parseInt(time / timeY) + 1) * costY;
    else sumY += costY;

    if (time >= timeM) sumM += (parseInt(time / timeM) + 1) * costM;
    else sumM += costM;
  }

  if (sumY < sumM) {
    console.log(`Y ${sumY}`);
  } else if (sumY === sumM) {
    console.log(`Y M ${sumY}`);
  } else {
    console.log(`M ${sumM}`);
  }

  process.exit();
});
