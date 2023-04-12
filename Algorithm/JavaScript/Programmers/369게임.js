function solution(order) {
  let answer = 0;
  let str = order + "";

  str.split("").map(x => {
    if (Number(x) > 0 && Number(x) % 3 === 0) answer++;
  });

  return answer;
}
