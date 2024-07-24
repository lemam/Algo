function solution(lines) {
  let answer = 0;
  const map = new Array(201);

  map.fill(0);

  for (const line of lines) {
    const start = line[0] + 100;
    const end = line[1] + 100;

    for (let i = start; i < end; i++) {
      map[i] += 1;
    }
  }

  for (const count of map) {
    if (count > 1) answer++;
  }

  return answer;
}
