function solution(A, B) {
  let start = A.indexOf(B[0], 0);
  let answer = A.length + 1;

  if (A === B) return 0;

  while (start > -1) {
    const isEnabled = [...B].every((ch, idx) => ch === A[(idx + start) % A.length]);
    if (isEnabled) answer = Math.min(answer, A.length - start);

    start = A.indexOf(B[0], start + 1);
  }

  return answer > A.length ? -1 : answer;
  // return (B + B).indexOf(A);
}
