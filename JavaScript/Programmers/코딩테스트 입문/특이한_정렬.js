function solution(numlist, n) {
  return numlist.sort((a, b) => {
    const aDist = Math.abs(n - a);
    const bDist = Math.abs(n - b);

    if (aDist === bDist) return b - a;
    return aDist - bDist;
  });
}
