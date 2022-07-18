import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
side_list = []

while True:
    sides = [*map(int, input().decode().split())]
    if sum(sides) == 0:
        break
    side_list.append(sides)


def what_kind_of_triagle(sides):
    a, b, c = sorted(sides)
    if a + b <= c:
        return "Invalid"
    if a == b == c:
        return "Equilateral"
    if a == b or b == c or c == a:
        return "Isosceles"
    return "Scalene"


print("\n".join(map(what_kind_of_triagle, side_list)))
