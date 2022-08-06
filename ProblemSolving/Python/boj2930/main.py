import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

R = int(read().decode())
shapes = read().decode()
N = int(read().decode())
friends = [list(read().decode().rstrip()) for _ in range(N)]

index = 0
score = 0
cheat = 0


def calculate(k, shape):
    s = 0
    for t in k:
        if shape == t:
            s += 1
        elif shape == "R" and t == "S":
            s += 2
        elif shape == "S" and t == "P":
            s += 2
        elif shape == "P" and t == "R":
            s += 2
    return s


for k in zip(*friends):
    r = calculate(k, "R")
    s = calculate(k, "S")
    p = calculate(k, "P")

    if shapes[index] == "R":
        score += r
    elif shapes[index] == "S":
        score += s
    elif shapes[index] == "P":
        score += p

    cheat += max([r, s, p])
    index += 1

print(score)
print(cheat)
