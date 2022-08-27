N, B = input().split()
B = int(B)
e = len(N) - 1

answer = 0

for i, c in enumerate(N):
    n = ((ord(c) & 31) + 9) if ord(c) > 64 else (ord(c) & 15)
    answer += n * (B ** (e - i))

print(answer)
