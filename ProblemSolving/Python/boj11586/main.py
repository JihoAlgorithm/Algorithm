N = int(input())
mirror = [input() for _ in range(N)]

print(
    [
        lambda: "\n".join(mirror),
        lambda: "\n".join(map(lambda l: "".join(reversed(l)), mirror)),
        lambda: "\n".join(reversed(mirror)),
    ][int(input()) - 1]()
)
