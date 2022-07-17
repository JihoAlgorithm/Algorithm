import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
T = int(input().decode())

while T > 0:
    T -= 1
    N, M = map(int, input().decode().split())
    _ = [input() for _ in range(M)]
    print(N - 1)
