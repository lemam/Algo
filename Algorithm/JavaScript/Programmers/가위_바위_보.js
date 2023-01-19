function solution(rsp) {
  let arr = ["2", "0", "5"];

  return [...rsp].map(x => arr[(arr.indexOf(x) + 1) % 3]).join("");
}
