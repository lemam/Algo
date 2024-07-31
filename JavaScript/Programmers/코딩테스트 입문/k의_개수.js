function solution(i, j, k) {
  let answer = 0;

  for (let num = i; num <= j; num++) {
    answer += [...num.toString()].filter(x => Number(x) === k).length;
  }

  return answer;
}
