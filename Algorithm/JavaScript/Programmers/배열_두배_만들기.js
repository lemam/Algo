function solution(numbers) {
  let result = [];
  numbers.forEach((el, idx) => {
    result[idx] = el * 2;
  });

  return result;
}
