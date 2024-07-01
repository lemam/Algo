function solution(s1, s2) {
  let answer = 0;

  for (const str of s1) {
    if (s2.find(el => el === str)) {
      answer++;
    }
  }

  return answer;
}
