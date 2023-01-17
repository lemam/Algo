function solution(my_string, letter) {
  var answer = my_string;

  while (answer.search(letter) >= 0) {
    answer = answer.replace(letter, "");
  }

  return answer;
}
