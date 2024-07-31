function solution(before, after) {
  const beforeMap = new Map();
  const afterMap = new Map();

  [...before].forEach(ch => beforeMap.set(ch, (beforeMap.get(ch) || 0) + 1));
  [...after].forEach(ch => afterMap.set(ch, (afterMap.get(ch) || 0) + 1));

  for (let key of beforeMap.keys()) {
    if (beforeMap.get(key) !== afterMap.get(key)) {
      return 0;
    }
  }

  return 1;
}
