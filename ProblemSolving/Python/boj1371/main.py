import sys

docs = sys.stdin.read()
docs = docs.replace("\n", "").replace(" ", "")
chars = [0] * 27

for c in docs:
    chars[ord(c) & 31] += 1

max_count = max(chars)
answer = ""

for i, c in enumerate(chars):
    if c == max_count:
        answer += chr(i + 96)

print(answer)
