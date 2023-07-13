"""
비밀번호 P는 000부터 999까지 번호 중의 하나이다.
주어지는 번호 K부터 1씩 증가하면서 탐색

ex)
P = 123
K = 100
123까지 24번 확인하여 비밀번호를 맞출 수 있다.

P와 K가 주어지면 K부터 시작하여 몇 번 만에 P를 맞출 수 있는지 출
"""

P, K = list(map(int, input().split()))

for i in list(range(K, P+1)):
    print(i)
##print(P - K + 1)
