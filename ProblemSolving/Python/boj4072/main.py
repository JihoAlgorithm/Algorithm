import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

while 1:
    words = input().decode().rstrip()
    if words == "#":
        break
    print(*map(lambda word: word[::-1], words.split()))
