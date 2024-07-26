function solution(babbling) {
  const words = ["aya", "ye", "woo", "ma"];
  let answer = 0;

  babbling.forEach(el => {
    words.forEach(word => (el = el.replaceAll(word, "*")));
    if (el.replaceAll("*", "").length === 0) answer++;
  });

  return answer;
}
