import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
f = [input().rstrip() for _ in range(int(input()))]

print(
    *[
        chr(k[0]) if sum(c * len(k) == sum(k) for c in k) == len(k) else "?"
        for k in zip(*f)
    ],
    sep="",
)
