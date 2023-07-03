"""
10개의 수에서 홀수만 더한 값을 출력 (각 수는 0 이상 10000 이하의 정수)

input:
    T = 3
    test_case = 3 17 1 39 8 41 2 32 99 2 (...)
output:
    # 1 200
    # 2 208
"""

T = int(input())

for test_case in range(1, T + 1):
    numbers = list(map(int, input().split()))
    answer = 0

    for num in numbers:
        if num % 2:
            answer += num
    
    print(f"#{test_case} {answer}")
