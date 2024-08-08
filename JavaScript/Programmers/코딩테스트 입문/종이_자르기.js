function solution(M, N) {
  // 세로 방향으로 자르기 + 가로 방향으로 자르기
  // M - 1 + M * (N - 1)
  return M * N - 1;
}
