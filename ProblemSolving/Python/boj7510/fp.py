import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

T = int(read().decode())
answer = []


def sides():
    yield sorted(map(int, read().decode().split()))


def is_right_triangle(sides):
    a, b, c = sides
    yield a**2 + b**2 == c**2


def take(length, _iter):
    res = []
    for item in _iter:
        res.append(item)
        if len(res) == length:
            return res
    return res


def reduce(f, acc, _iter):
    for item in _iter:
        answer.append(f"Scenario #{acc}:")
        answer.append


for t in range(T):
    header = f"Scenario #{t + 1}:"
    print("yes\n" if is_right_triangle(sides()) else "no\n")
