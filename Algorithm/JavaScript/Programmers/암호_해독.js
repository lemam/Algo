function solution(cipher, code) {
  let answer = "";

  for (let i = 1; code * i - 1 < cipher.length; i++) {
    answer += cipher.charAt(code * i - 1);
  }

  return answer;
}
