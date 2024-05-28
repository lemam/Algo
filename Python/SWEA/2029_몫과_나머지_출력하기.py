"""
2개의 수 a, b를 입력 받아, a를 b로 나눈 몫과 나머지를 출력
각 수는 1이상 10000이하의 정수이다.
"""

T = int(input())

for t in range(1, T + 1):
    a, b = list(map(int, input().split()))
    print(f"#{t} {a // b} {a % b}")
