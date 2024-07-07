function solution(quiz) {
  const answer = [];

  for (q of quiz) {
    const qArr = q.split(" ");
    let result = 0;

    switch (qArr[1]) {
      case "+":
        result = Number(qArr[0]) + Number(qArr[2]);
        break;
      case "-":
        result = Number(qArr[0]) - Number(qArr[2]);
    }

    answer.push(result === Number(qArr[4]) ? "O" : "X");
  }

  return answer;
}
