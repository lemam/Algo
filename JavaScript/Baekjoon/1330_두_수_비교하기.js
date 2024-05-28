let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split(" ");

// let str = "1 2";
// let input = str.toString().split(" ");

let A = parseInt(input[0]);
let B = parseInt(input[1]);

if (A > B) console.log(">");
else if (A < B) console.log("<");
else console.log("==");
