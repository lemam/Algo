// s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 반환하기
// 한 번만 등장하는 문자가 없을 경우 빈 문자열을 반환한다.

// param {String} s
// return {String} s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열 또는 빈 문자열

// example
// s      = "abcabcadc"
// result = "d"

function solution(s) {
  return [...s]
    .filter(ch => s.match(new RegExp(ch, "g")).length === 1)
    .sort()
    .join();
}
