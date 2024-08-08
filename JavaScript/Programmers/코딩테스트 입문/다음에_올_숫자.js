function solution(common) {
  const length = common.length;
  const diff1 = common[length - 1] - common[length - 2];
  const diff2 = common[length - 2] - common[length - 3];

  if (diff1 === diff2) return common[length - 1] + diff1;
  else return common[length - 1] * (common[length - 1] / common[length - 2]);
}
