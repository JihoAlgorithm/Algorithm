s, B = input().split()
B = int(B)
e = len(s) - 1

answer = 0

for i, c in enumerate(s):
    n = ((ord(c) & 31) + 9) if ord(c) > 64 else (ord(c) & 15)
    answer += n * (B ** (e - i))

print(answer)
