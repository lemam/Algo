function solution(my_string) {
  return [...new Set(my_string.split(""))].reduce((acc, cur) => acc + cur, "");
}
