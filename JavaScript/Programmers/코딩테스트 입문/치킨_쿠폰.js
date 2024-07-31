function solution(chicken) {
  let answer = 0;
  let coupon = chicken;

  while (coupon >= 10) {
    const service = Math.floor(coupon / 10); // 주문할 수 있는 서비스 치킨의 개수
    coupon = service + Math.floor(coupon % 10); // 서비스 치킨을 받고 난 후의 쿠폰 개수 (서비스 치킨 + 남은 쿠폰)
    answer += service;
  }

  return answer;
}
