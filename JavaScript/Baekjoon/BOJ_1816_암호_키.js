const fs = require('fs');

// N: 수의 개수
// numbers: 확인하고자 하는 수의 배열
const [N, ...numbers] = fs
  .readFileSync('/dev/stdin')
  .toString()
  .split('\n')
  .filter(Boolean)
  .map(BigInt); // S의 최대값이 `10^18`이기 때문에 Number의 안전한 최대값인 `2^53 - 1`보다 크므로 BigInt를 사용한다.

// 모든 테스트케이스 순회
for (const S of numbers) {
  let answer = 'YES';

  // 2 이상 1,000,000 이하의 수 중 나누어 떨어지는 수가 있다면
  // 1,000,000 이하의 약수가 있으므로 암호키로 적절하지 않다.
  for (let j = 2n; j <= 1000000n; j++) {
    if (S % j === 0n) {
      answer = 'NO';
      break;
    }
  }

  console.log(answer);
}
