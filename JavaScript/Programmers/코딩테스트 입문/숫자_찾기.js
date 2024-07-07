function solution(num, k) {
  const strNumArr = num.toString().split("");
  const index = strNumArr.indexOf(k.toString());

  return index >= 0 ? index + 1 : -1;
}
