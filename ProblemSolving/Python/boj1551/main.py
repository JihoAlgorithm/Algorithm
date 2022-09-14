from functools import reduce

N, K = map(int, input().split())
A = map(int, input().split(","))
B = []


def sub_and_append(prev, next):
    B.append(next - prev)
    return next


for _ in range(K):
    reduce(sub_and_append, A)
    A, B = B, []

print(*A, sep=",")
