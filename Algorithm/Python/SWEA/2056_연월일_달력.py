"""
연월일 순으로 구성된 8자리의 날짜가 입력으로 주어진다.

2220228 -> 2222/02/28

날짜의 유효성을 판단한 후,
유효하다면 YYYY/MM/DD 형식으로 출력
날짜가 유효하지 않을 경우, -1 출력

월은 1 ~ 12 사이의 값
일은 1일 ~ 각각의 달에 해당하는 날짜까지의 값

(2월의 경우 28일 경우만 고려, 윤년은 고려하지 않음)
"""

T = int(input())

days = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

for t in range(1, T + 1):
    date = input()
    year = date[:4]
    month = date[4:6]
    day = date[-2:]

    if (0 < int(month) <= 12 and 0 < int(day) <= days[int(month)]):
        print(f"#{t} {year}/{month}/{day}")
    else:
        print(f"#{t} -1")
    
