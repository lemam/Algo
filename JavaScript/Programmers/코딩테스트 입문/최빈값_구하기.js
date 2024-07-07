function solution(array) {
  let map = new Map();
  for (let num of array) map.set(num, (map.get(num) || 0) + 1);
  let arr = [...map].sort((a, b) => b[1] - a[1]);

  return arr.length === 1 || arr[0][1] > arr[1][1] ? arr[0][0] : -1;
}
