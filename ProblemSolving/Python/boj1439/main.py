import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
S = input().rstrip()
count = [0] * 2

for i in range(1, len(S)):
    if S[i - 1] != S[i]:
        count[S[i - 1] & 15] += 1

print(max(count))
