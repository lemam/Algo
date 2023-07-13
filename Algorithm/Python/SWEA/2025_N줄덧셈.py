"""
1부터 주어진 숫자만큼 모두 더한 값 출력

단, 주어질 숫자는 10000을 넘지 않는다.

ex)
주어진 숫자 = 10
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55
"""

N = int(input())
answer = 0

for i in range(1, N + 1):
    answer += i

print(answer)
