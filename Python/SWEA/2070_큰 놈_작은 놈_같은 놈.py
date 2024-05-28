"""
2개의 수를 입력 받아 크기를 비교하여 등호 또는 부등호를 출력
각 수는 0 이상 10000 이하의 정수이다.

"""

T = int(input())

for t in range(1, T + 1):
    a, b = list(map(int, input().split()))
    answer = ""

    if a > b:
        answer = ">"
    elif a == b:
        answer = "="
    else:
        answer = "<"

    print(f"#{t} {answer}")
