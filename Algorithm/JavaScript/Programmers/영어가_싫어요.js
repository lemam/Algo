// 영어로 표기되어 있는 숫자를 수로 바꾸기

// param {String} numbers
// return {Number} numbers를 정수로 바꾼 값

// example
// numbers : "onetwothreefourfivesixseveneightnine"
// return  : 123456789

function solution(numbers) {
  const numStr = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];

  numStr.forEach((str, idx) => {
    numbers = numbers.replaceAll(str, idx);
  });

  return Number(numbers);
}
