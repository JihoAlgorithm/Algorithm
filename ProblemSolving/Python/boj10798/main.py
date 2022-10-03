import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
cols = [""] * 15

for _ in range(5):
    for i, c in enumerate(input().rstrip().decode()):
        cols[i] += c

print(*cols, sep="")
