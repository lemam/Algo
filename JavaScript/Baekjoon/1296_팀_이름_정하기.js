let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

const myName = input[0];
const N = parseInt(input[1]);

let myNameCount = countAlphabet(myName);
let teams = [];

for (let i = 2; i < 2 + N; i++) {
  let teamName = input[i];
  let teamNameCount = countAlphabet(teamName);

  let team = new Object();
  team.name = teamName;
  team.prob = solution(teamNameCount);

  teams.push(team);
}

teams.sort(function (a, b) {
  if (a.prob - b.prob === 0) {
    if (a.name > b.name) return 1;
    else if (a.name < b.name) return -1;
    else return 0;
  }

  return b.prob - a.prob;
});

console.log(teams[0].name);

function solution(nameCount) {
  let L = nameCount[0] + myNameCount[0];
  let O = nameCount[1] + myNameCount[1];
  let V = nameCount[2] + myNameCount[2];
  let E = nameCount[3] + myNameCount[3];

  return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
}

function countAlphabet(name) {
  let tempCount = new Array(4).fill(0); // L, O, V, E

  for (let i = 0; i < name.length; i++) {
    switch (name[i]) {
      case "L":
        tempCount[0]++;
        break;
      case "O":
        tempCount[1]++;
        break;
      case "V":
        tempCount[2]++;
        break;
      case "E":
        tempCount[3]++;
        break;
      default:
    }
  }

  return tempCount;
}
