function fnGCD(a, b) {
  return b ? fnGCD(b, a % b) : a;
}

function solution(numer1, denom1, numer2, denom2) {
  let numer = numer1 * denom2 + numer2 * denom1;
  let denom = denom1 * denom2;
  let gcd = fnGCD(numer, denom);

  return [numer / gcd, denom / gcd];
}
