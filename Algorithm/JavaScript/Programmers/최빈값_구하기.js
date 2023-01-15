function solution(array) {
  let arr = new Array(1000).fill(0);
  var answer = 0;

  array.forEach(el => arr[el]++);
  console.log(arr);

  let cnt = 0;
  let temp = 0;
  arr.forEach((el, idx) => {
    if (el > temp) {
      temp = el;
      cnt = 0;
      answer = idx;
    } else if (el === temp) {
      cnt++;
    }
  });

  return cnt ? -1 : answer;
}
