"""
하나의 자연수를 입력 받아 각 자릿수의 합 계산
(1 ≤ N ≤ 9999)

input {str} N
output {str} 각 자릿수의 합

example
input = 6789
output = 30
"""

N = int(input())

result = 0

while N:
    rem = N % 10
    N = N // 10
    result += rem
    
print(result)

