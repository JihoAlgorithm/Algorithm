import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

while 1:
    s = input().rstrip()
    if s == b"#":
        break
    k = s.split()
    print(*map(lambda x: x.decode(), k), end=" ")
    print("".join(chr(((c & 31) + b - a - 1) % 26 + 97) for a, b, c in zip(*k)))
