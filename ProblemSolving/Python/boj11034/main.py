import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
answer = []

while True:
    tc = read().decode()
    if not tc:
        break
    a, b, c = sorted(map(int, tc.split()))
    answer.append(str(max(c - b, b - a) - 1))

print("\n".join(answer))
