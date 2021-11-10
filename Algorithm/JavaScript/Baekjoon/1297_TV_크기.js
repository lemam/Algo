let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

let D = Number(input[0]);
let H = Number(input[1]);
let W = Number(input[2]);

let x = Math.sqrt((D * D) / (H * H + W * W));
let height = Math.floor(H * x);
let width = Math.floor(W * x);

console.log(`${Math.floor(height)} ${Math.floor(width)}`);
