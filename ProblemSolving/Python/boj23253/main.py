import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline


def read():
    return map(int, input().decode().split())


N, M = read()
pile = [*map(lambda t: t[1], [(input(), [*read()]) for _ in range(M)])]
pile = [*map(lambda p: zip(p, p[1:]), pile)]
pile = [[*map(lambda t: t[0] < t[1], p)] for p in pile]
pile = [n for p in pile for n in p]

print("No" if any(pile) else "Yes")
