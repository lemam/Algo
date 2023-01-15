function solution(numer1, denom1, numer2, denom2) {
  let numer = 0;
  let denom = 0;

  if (denom1 === denom2) {
    numer = numer1 + numer2;
    denom = denom1;
  } else {
    numer = numer1 * denom2 + numer2 * denom1;
    denom = denom1 * denom2;
  }

  for (let i = 2; i <= denom; ) {
    if (numer % i == 0 && denom % i == 0) {
      numer /= i;
      denom /= i;
    } else i++;
  }

  var answer = [numer, denom];
  return answer;
}
