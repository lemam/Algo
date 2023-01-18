function solution(age) {
  return Array.from(String(age), x =>
    String.fromCharCode("a".charCodeAt(0) + Number(x))
  ).join("");
}
