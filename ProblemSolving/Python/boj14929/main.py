import io
import os
from itertools import accumulate

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

n = int(input().decode())
x = [*map(int, input().decode().split())]
p = [*accumulate(x)]
s = 0

for i in range(n):
    s += x[i] * (p[n - 1] - p[i])

print(s)
