function solution(s) {
  let answer = [];
  const charMap = new Map();

  [...s].map(x => charMap.set(x, charMap.get(x) + 1 || 1));

  for (let key of charMap.keys()) {
    if (charMap.get(key) > 1) continue;
    answer.push(key);
  }

  return answer.sort().join("");
}
