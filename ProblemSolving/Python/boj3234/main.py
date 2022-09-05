answer = []
luka = [*map(int, input().split())]
makers = [0, 0]

mapper = {"I": [1, 0], "S": [0, 1], "Z": [-1, 0], "J": [0, -1]}
K = int(input())
routes = input()


def overhear(a, b):
    return abs(a[0] - b[0]) < 2 and abs(a[1] - b[1]) < 2


for i, c in enumerate(routes):
    if overhear(luka, makers):
        answer.append(i)
    makers[0] += mapper[c][0]
    makers[1] += mapper[c][1]

if overhear(luka, makers):
    answer.append(K)

print(*answer, sep="\n") if answer else print(-1)
