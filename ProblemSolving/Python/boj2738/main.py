N, M = map(int, input().split())
A = [[*map(int, input().split())] for _ in range(N)]
B = [[*map(int, input().split())] for _ in range(N)]

for row in zip(A, B):
    print(*[sum(x) for x in zip(*row)])
