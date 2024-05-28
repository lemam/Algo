"""
10개의 수를 입력 받아, 평균값을 출력
소수점 첫째 자리에서 반올림한 정수를 출력한다.

각 수는 0 이상 10000 이하의 정수이다.
"""

T = int(input())

for t in range(1, T + 1):
    numbers = list(map(int, input().split()))
    average = round(sum(numbers) / 10)
    
    print(f"#{t} {average}")
