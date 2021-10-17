const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

let dices = [];
for (let i = 0; i < input.length; i++) {
  dices[i] = Number(input[i]);
}

let sumMap = new Map();
let result = 0,
  cnt = 0;

for (let i = 1; i <= dices[0]; i++) {
  for (let j = 1; j <= dices[1]; j++) {
    for (let k = 1; k <= dices[2]; k++) {
      let sum = i + j + k;
      if (sumMap.has(sum)) sumMap.set(sum, sumMap.get(sum) + 1);
      else sumMap.set(sum, 1);
    }
  }
}

sumMap.forEach((value, key) => {
  console.log(`key : ${key}, value : ${value}`);

  if (cnt < value) {
    cnt = value;
    result = key;
  }
});

console.log(result);
