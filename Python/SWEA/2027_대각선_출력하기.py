"""
#++++
+#+++
++#++
+++#+
++++#

위의 텍스트 출력
"""

for i in range(5):
    for j in range(5):
        if i == j:
            print('#', end='')
        else:
            print('+', end='')
    print()
