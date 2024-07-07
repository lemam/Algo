function solution(price) {
  let rate = 0;

  if (price >= 500000) rate = 20;
  else if (price >= 300000) rate = 10;
  else if (price >= 100000) rate = 5;

  return Math.floor(price * ((100 - rate) / 100));
}
