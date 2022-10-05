import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
N = int(input())
words = [input().rstrip() for _ in range(N)]

for i in range(N):
    for j in range(i, N):
        if not sum(map(lambda x: x[0] != x[1], zip(words[i], reversed(words[j])))):
            print(len(words[i]), chr(words[i][len(words[i]) >> 1]))
