const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const castleSize = input[0].split(" ");
const N = parseInt(castleSize[0]);
const M = parseInt(castleSize[1]);

let line = [];
let guardCol = new Array(M).fill(true);
let guardRow = new Array(N).fill(true);
let guardColSeat = 0;
let guardRowSeat = 0;
let answer = 0;

function CountSeat(arr) {
  let cnt = 0;
  for (let i = 0; i < arr.length; i++) {
    if (arr[i]) cnt++;
  }

  return cnt;
}

for (let i = 1; i <= N; i++) {
  for (let j = 0; j < M; j++) {
    line[j] = input[i].toString().substr(j, 1);
    if (line[j] === "X") {
      guardCol[j] = false;
      guardRow[i - 1] = false;
    }
  }
  line = [];
}

guardColSeat = CountSeat(guardCol);
guardRowSeat = CountSeat(guardRow);

if (guardColSeat < guardRowSeat) {
  answer = guardColSeat + (guardRowSeat - guardColSeat);
} else {
  answer = guardRowSeat + (guardColSeat - guardRowSeat);
}

console.log(answer);
