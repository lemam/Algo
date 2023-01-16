function solution(money) {
  let cnt = parseInt(money / 5500);
  return [cnt, money - 5500 * cnt];
}
