const factorialize = num => (num === 0 ? 1 : num * factorialize(num - 1));

function solution(balls, share) {
  return Math.round(
    factorialize(balls) / factorialize(balls - share) / factorialize(share)
  );
}
