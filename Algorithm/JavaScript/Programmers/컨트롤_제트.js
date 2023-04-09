function solution(s) {
  let answer = 0;
  let arr = s.split(" ");

  for (let i = arr.length - 1; i >= 0; i--) {
    if (isNaN(Number(arr[i]))) i--;
    else answer += Number(arr[i]);
  }

  return answer;
}
