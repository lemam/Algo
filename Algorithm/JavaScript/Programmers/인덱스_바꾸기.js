function solution(my_string, num1, num2) {
  let answer = [...my_string];

  answer.splice(num1, 0, my_string[num2]);
  answer.splice(num1 + 1, 1);

  answer.splice(num2, 0, my_string[num1]);
  answer.splice(num2 + 1, 1);

  return answer.join("");
}
