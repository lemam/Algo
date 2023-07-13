"""
알파벳으로 이루어진 문자열을 입력 받음
각 알파벳을 1부터 26까지의 숫자로 변환하여 출력

문자열의 최대 길이는 200이다.
각 알파벳을 숫자로 변환한 결과값을 빈 칸을 두고 출력한다.
"""

answer = ""

for ch in list(input()):
    answer += str(ord(ch) - 64) + " "

print(answer)
