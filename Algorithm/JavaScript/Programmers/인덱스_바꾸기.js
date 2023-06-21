// my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 반환하기

// param {String} my_string
// param {Number} num1
// param {Number} num2
// return {String} my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열

// example
// my_string : "hello"
// num1      : 1
// num2      : 2
// return    : "hlelo"

function solution(my_string, num1, num2) {
  my_string = my_string.split("");
  [my_string[num1], my_string[num2]] = [my_string[num2], my_string[num1]];

  return my_string.join("");
}
