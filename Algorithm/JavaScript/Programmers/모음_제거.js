function solution(my_string) {
  let vowels = ["a", "e", "i", "o", "u"];
  return [...my_string].filter(ch => vowels.findIndex(word => word === ch) < 0).join("");
}
