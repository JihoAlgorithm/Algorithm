import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

T = int(read().decode())


def sides():
    return [*map(int, read().decode().split())]


def is_right_triangle(a, b, c):
    return a**2 + b**2 == c**2


for t in range(T):
    print(f"Scenario #{t + 1}:")
    print("yes\n" if is_right_triangle(*sorted(sides())) else "no\n")
