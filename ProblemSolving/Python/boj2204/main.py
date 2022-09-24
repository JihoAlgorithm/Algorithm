import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

while 1:
    n = int(input())
    if not n:
        break
    words = [input() for _ in range(n)]
    print(sorted(words, key=lambda word: word.upper())[0].rstrip().decode())
