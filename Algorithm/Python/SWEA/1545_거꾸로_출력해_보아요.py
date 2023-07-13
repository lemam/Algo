"""
주어진 숫자부터 0까지 순서대로 찍어보세요

N N-1 N-2 ... 0
"""

n = int(input())
s = ""

for i in range(n, -1, -1):
    print(i, end = ' ')
