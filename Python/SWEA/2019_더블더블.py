"""
1부터 주어진 횟수까지 2를 곱한 값(들)을 출력
주어질 숫자는 30을 넘지 않는다.
"""

import math

for i in range(int(input()) + 1):
    print(int(math.pow(2, i)), end = ' ')    
