import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

for _ in range(int(input())):
    print(*reversed(input().decode()[::-1].split()))
