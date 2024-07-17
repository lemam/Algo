function solution(sides) {
  let answer = 0;
  let max = Math.max(...sides);
  let min = Math.min(...sides);

  // 만약 기존 요소 중 가장 긴 변이 있는 경우
  // max - min + 1 : 가장 긴 변은 다른 두 변의 길이의 합보다 작아야 하므로
  for (let i = max - min + 1; i <= max; i++) {
    answer++;
  }

  // 나머지 한 변이 가장 긴 변인 경우
  for (let i = max + 1; i < max + min; i++) {
    answer++;
  }

  return answer;
}
