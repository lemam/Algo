function solution(my_string) {
  const numberStr = my_string.replaceAll(/[A-z]/g, "*");
  return numberStr.split("*").reduce((acc, curr) => acc + Number(curr), 0);
}
