import io
import os
from itertools import accumulate

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N, Q = map(int, read().decode().split())
notes = [*accumulate([int(read().decode()) for _ in range(N)])]
answer = []

for _ in range(Q):
    time = int(read().decode())
    for i, B in enumerate(notes):
        if time < B:
            answer.append(str(i + 1))
            break

print("\n".join(answer))
