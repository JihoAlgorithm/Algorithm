K = int(input())
p = input()
rows = [p[j : j + K][:: [1, -1][i & 1]] for i, j in enumerate(range(0, len(p), K))]
print(*["".join(row) for row in zip(*rows)], sep="")
