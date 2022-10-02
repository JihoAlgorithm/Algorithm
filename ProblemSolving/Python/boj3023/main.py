import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
R, C = map(int, input().split())
design = [[*input().rstrip()] for _ in range(R)]
bottom = []
A, B = map(int, input().split())

for r in range(R):
    design[r] += [*reversed(design[r])]
    bottom.insert(0, design[r].copy())

design += bottom
design[A - 1][B - 1] = [35, 46][design[A - 1][B - 1] == 35]

for row in design:
    print(*map(chr, row), sep="")
