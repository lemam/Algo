function solution(emergency) {
  var answer = [];
  let arr = emergency.slice().sort((a, b) => b - a);
  let order = 1;

  for (n of arr) {
    answer[emergency.findIndex(el => el == n)] = order++;
  }

  return answer;
}
