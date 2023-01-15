function solution(array) {
  array.sort((a, b) => {
    if (a > b) return 1;
    else return -1;
  });
  return array[parseInt(array.length / 2)];
}
