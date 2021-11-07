let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = parseInt(input[0]);
let classArray = new Array(N);
let friendArray = new Array(N);
let result = 0;
let cnt = 0;

// Init
for (let i = 1; i <= N; i++) {
  let arr = input[i].split(" ");
  classArray[i - 1] = arr;
  friendArray[i - 1] = new Array(N).fill(0);
}

// (n+1)번이 (g+1)학년 때 (i+1)번 학생과 같은 반이었는지 탐색
for (let n = 0; n < N; n++) {
  for (let g = 0; g < 5; g++) {
    let myClass = classArray[n][g];
    for (let i = 0; i < N; i++) {
      if (n === i) continue;
      if (friendArray[n][i]) continue;

      let friendClass = classArray[i][g];
      if (myClass === friendClass) friendArray[n][i] = 1;
    }
  }
}

for (let i = 0; i < N; i++) {
  let temp = 0;

  for (let j = 0; j < N; j++) {
    temp += friendArray[i][j];
  }

  if (temp > cnt) {
    cnt = temp;
    result = i;
  }
}

console.log(result + 1);
