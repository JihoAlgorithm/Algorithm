import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline


def convert(a):
    if a > 22:
        return 9
    if a > 19:
        return 8
    if a > 15:
        return 7
    return 2 + (a - 1) // 3


for _ in range(int(input())):
    number = [convert(c & 31) for c in input().rstrip()]

    i = 0
    l = len(number)
    m = l // 2

    while i < m:
        if number[i] != number[l - i - 1]:
            break
        i += 1

    print("YNEOS"[i < m :: 2])
