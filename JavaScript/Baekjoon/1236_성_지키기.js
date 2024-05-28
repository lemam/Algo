const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const castleSize = input[0].split(" ");
const N = parseInt(castleSize[0]); // row number
const M = parseInt(castleSize[1]); // col number

let line = [];
let guardCol = new Array(M).fill(true);
let guardRow = new Array(N).fill(true);
let guardColSeat = 0;
let guardRowSeat = 0;

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

guardColSeat = guardCol.reduce(function (pv, cv) {
  return pv + cv;
});
guardRowSeat = guardRow.reduce(function (pv, cv) {
  return pv + cv;
});

console.log(Math.max(guardColSeat, guardRowSeat));
