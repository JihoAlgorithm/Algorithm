import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

room = [input().rstrip().decode() for _ in range(int(input()))]
f = lambda l: len([*filter(lambda x: len(x) > 1, l)])
h = f(sum([line.split("X") for line in room], []))
v = f(sum(["".join(line).split("X") for line in zip(*room)], []))

print(h, v)
