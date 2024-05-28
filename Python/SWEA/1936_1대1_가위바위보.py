"""
A와 B가 가위바위보를 한다.
가위 = 1, 바위 = 2, 보 = 3로 표현
A와 B중에 누가 이겼는지 판별하기.
단, 비기는 경우는 없음

input {str} A와 B가 무엇을 냈는지 빈 칸을 사이로 주어진다.
output {str} A와 B 중 이긴 사람

example
input = "3 2"
output = "A"
"""

winNum = [0, 3, 1, 2]

a, b = list(map(int, input().split()))

if winNum[a] == b:
    print("A")
else:
    print("B")
    
