"""
10개의 수 중 가장 큰 수 출력 (각 수는 0 이상 10000 이하 자연수)

input:
    T = 3
    test_case = 3 17 1 39 8 41 2 32 99 2 (...)
output:
    # 1 99
    # 2 123
"""

T = int(input())

for test_case in range(1, T + 1):
    numbers = list(map(int, input().split()))
    print(f"#{test_case} {max(numbers)}")

