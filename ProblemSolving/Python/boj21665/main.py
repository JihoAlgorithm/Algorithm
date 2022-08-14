N, M = map(int, input().split())
P = [[input() for _ in range(N)], input(), [input() for _ in range(N)]]
print(sum(c[0] == c[1] for r in zip(P[0], P[2]) for c in zip(*r)))
