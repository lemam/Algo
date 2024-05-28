let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let today = input[0].split(" ").map(el => parseInt(el));
let dday = input[1].split(" ").map(el => parseInt(el));

solution();

function solution() {
  let todayDays = getDays(today[0], today[1], today[2]);
  let ddayDays = getDays(dday[0], dday[1], dday[2]);

  if (dday[0] - today[0] > 1000) console.log("gg");
  else if (dday[0] - today[0] === 1000 && dday[1] >= today[1] && dday[2] >= today[2]) {
    console.log("gg");
  } else console.log(`D-${ddayDays - todayDays}`);
}

function getDays(year, month, day) {
  let isLeapYear = checkLeapYear(year);
  let days = 0;

  for (let i = 1; i < year; i++) {
    days += 365 + checkLeapYear(i);
  }

  for (let m = 1; m <= month; m++) {
    let endDay = 0;

    switch (m) {
      case month:
        endDay = day;
        break;
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        endDay = 31;
        break;
      case 2:
        if (isLeapYear) endDay = 29;
        else endDay = 28;
        break;
      default:
        endDay = 30;
    }

    days += endDay;
  }

  return days;
}

function checkLeapYear(year) {
  if (year % 400 === 0) return true;
  else if (year % 100 === 0) return false;
  else if (year % 4 === 0) return true;

  return false;
}
