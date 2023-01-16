function solution(num_list) {
  var answer = [0, 0];

  num_list.forEach(el => {
    if (el % 2) answer[1]++;
    else answer[0]++;
  });

  return answer;
}
