import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
formatter = bytes.maketrans(b"TH", b"01")


def start_index(start, _iter):
    for i in range(start, len(_iter)):
        yield _iter[i]


for _ in range(int(input())):
    seq = input().rstrip().translate(formatter).decode()
    counts = [0] * 8

    for coins in zip(start_index(0, seq), start_index(1, seq), start_index(2, seq)):
        counts[int("".join(coins), 2)] += 1

    print(*counts)
