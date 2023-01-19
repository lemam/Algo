function solution(hp) {
  var answer = 0;
  let ant = [5, 3, 1];

  for (attack of ant) {
    answer += ~~(hp / attack);
    hp = hp % attack;
  }

  return answer;
}
