// 편지의 글자 한 자의 가로 길이 = 2cm
// 편지를 가로로만 적을 때, 축하 문구 message를 적기 위해 필요한 편지지의 최소 가로 길이는?

// param {String} message
// return {Number} 편지지의 최소 가로 길이

// example
// message = "happy birthday!"
// result  = 30

function solution(message) {
  const size = 2;

  return message.length * size;
}
