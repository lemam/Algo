function solution(my_string) {
  const arr = my_string.split(" ");
  let answer = 0;

  for (let i = 0; i < arr.length; i++) {
    let op = 1;

    // 더하기인 경우
    if (arr[i] === "+") {
      op = 1;
    }
    // 빼기인 경우
    else if (arr[i] === "-") {
      op = -1;
    }
    // 숫자인 경우
    else {
      answer += op * Number(arr[i]);
    }
  }

  return answer;
}
