import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
R, C, ZR, ZC = map(int, input().split())

for _ in range(R):
    for k in [[chr(c) * ZC for c in input().rstrip()]] * ZR:
        print(*k, sep="")
