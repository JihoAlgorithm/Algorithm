N, M = map(int, input().split())
before = [input() for _ in range(N)]
input()
after = [input() for _ in range(N)]

# count = 0

# for r1, r2 in zip(before, after):
#     for c1, c2 in zip(r1, r2):
#         count += c1 == c2

print(sum(c1 == c2 for r1, r2 in zip(before, after) for c1, c2 in zip(r1, r2)))
