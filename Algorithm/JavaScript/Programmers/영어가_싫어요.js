function solution(numbers) {
  const numArray = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
  let answer = "";
  let idx = 0;

  while (idx < numbers.length) {
    for (let i = 0; i < numArray.length; i++) {
      if (numbers.startsWith(numArray[i], idx)) {
        answer += i;
        idx += numArray[i].length;
        break;
      }
    }
  }

  return Number(answer);
}
