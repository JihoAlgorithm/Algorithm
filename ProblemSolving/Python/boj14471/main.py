import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N, M = map(int, read().decode().split())
deck = [[*map(int, read().decode().split())] for _ in range(M)]
deck.sort(key=lambda x: x[1])
deck.pop()

cost = 0

for card in deck:
    if card[0] < N:
        cost += N - card[0]

print(cost)
