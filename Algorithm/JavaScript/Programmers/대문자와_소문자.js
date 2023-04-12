function solution(my_string) {
  return my_string
    .split("")
    .map(x => {
      if (/[A-Z]/.test(x)) return x.toLowerCase();
      else return x.toUpperCase();
    })
    .join("");
}
