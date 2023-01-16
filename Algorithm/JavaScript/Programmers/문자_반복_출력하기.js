function solution(my_string, n) {
  var answer = "";

  my_string.split("").forEach(el => {
    answer += el.repeat(n);
  });

  return answer;
}
