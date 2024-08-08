function solution(num, total) {
  const midNum = parseInt(total / num); // 중간값
  const diff = (num - 1) / 2; // 가운데를 기준으로 나열된 숫자의 개수
  const start = midNum - parseInt(diff);
  const end = midNum + Math.ceil(diff);
  const answer = [];

  for (let i = start; i <= end; i++) {
    answer.push(i);
  }

  return answer;
}
