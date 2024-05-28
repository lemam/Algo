let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

const n = BigInt(input[0]);
const m = BigInt(input[1]);
let result = n / m;
let remainder = n % m;

console.log(`${result.toString()}\n${remainder.toString()}`);
