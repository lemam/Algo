function solution(array, n) {
  var answer = array[0];
  let diff = n;

  for (const el of array) {
    let temp = Math.abs(el - n);

    if (temp < diff) {
      diff = temp;
      answer = el;
    } else if (temp === diff) {
      answer = answer > el ? el : answer;
    }
  }

  return answer;
}
