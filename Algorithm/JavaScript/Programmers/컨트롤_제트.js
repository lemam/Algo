function solution(s) {
  const stack = [];

  s.split(" ").forEach(ch => {
    if (ch === "Z") stack.pop();
    else stack.push(+ch);
  });

  return stack.length ? stack.reduce((acc, cur) => acc + cur) : 0;
}
