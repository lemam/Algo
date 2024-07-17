function solution(spell, dic) {
  for (const word of dic) {
    const counter = {};
    let flag = true;

    [...word].forEach(el => (counter[el] = ++counter[el] || 1));

    for (const alpha of spell) {
      if (counter[alpha] !== 1) {
        flag = false;
        break;
      }
    }

    if (flag) return 1;
  }

  return 2;
}
