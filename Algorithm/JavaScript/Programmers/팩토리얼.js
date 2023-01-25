function solution(n) {
  for (let i = 1, v = 1; ; v *= ++i) {
    if (v > n) return --i;
  }
}
