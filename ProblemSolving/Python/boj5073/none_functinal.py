import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
answer = []


def what_kind_of_triagle(a, b, c):
    if a + b <= c:
        return "Invalid"
    if a == b == c:
        return "Equilateral"
    if a == b or b == c or c == a:
        return "Isosceles"
    return "Scalene"


while True:
    sides = sorted(map(int, input().decode().split()))
    if sides[-1] == 0:
        break
    answer.append(what_kind_of_triagle(*sides))

print("\n".join(answer))
