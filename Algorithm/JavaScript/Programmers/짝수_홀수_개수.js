function solution(num_list) {
  var answer = [0, 0];

  for (const num of num_list) {
    answer[num % 2] += 1;
  }

  return answer;
}
