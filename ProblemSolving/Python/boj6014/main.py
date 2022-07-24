import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N, Q = map(int, read().decode().split())
answer = [0] * 1_200_001

time = 0
note = 1

for _ in range(N):
    for __ in range(int(read().decode())):
        answer[time] = note
        time += 1
    note += 1

for _ in range(Q):
    print(answer[int(read().decode())])
