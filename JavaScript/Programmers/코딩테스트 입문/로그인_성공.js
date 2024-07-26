function solution(id_pw, db) {
  const [userId, userPw] = id_pw;

  for (const [id, pw] of db) {
    if (userId === id) {
      if (userPw === pw) return "login";
      else return "wrong pw";
    }
  }

  return "fail";
}
