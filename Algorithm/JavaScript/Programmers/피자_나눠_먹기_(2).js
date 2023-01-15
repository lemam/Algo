function fnGDC(a, b) {
  return b ? fnGDC(b, a % b) : a;
}

function solution(n) {
  return n / fnGDC(n, 6);
}
