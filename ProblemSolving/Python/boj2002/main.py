import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N = int(input())
cars = [input() for _ in range(N)]
cnt, idx = 0, 0

for _ in range(N):
    num = input()
    cnt += cars[0] != num
    cars.remove(num)

print(cnt)
