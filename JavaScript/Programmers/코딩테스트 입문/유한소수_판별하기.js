function solution(a, b) {
  // a, b의 최대공약수 구하는 함수
  const getGCD = (a, b) => (a % b == 0 ? b : getGCD(b, a % b));

  // 분모를 최대공약수로 나누어 기약분수의 분모로 만들기
  let denom = b / getGCD(a, b);

  // 분모를 2와 5로 각각 소인수분해
  while (denom % 2 === 0) denom /= 2;
  while (denom % 5 === 0) denom /= 5;

  return denom === 1 ? 1 : 2;
}
