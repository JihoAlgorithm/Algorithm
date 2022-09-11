import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
files = [input().rstrip() for _ in range(int(input()))]
answer = ""

for letters in zip(*files):
    s = sum(letters)
    l = len(letters)
    answer += chr(letters[0]) if sum(c * l == s for c in letters) == l else "?"

print(answer)
