import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
N = int(input().decode())


class Counter(dict):
    def __missing__(self, key):
        return 0


for i in range(1, N + 1):
    counter = Counter()

    for c in input():
        counter[c] += 1
    for c in input():
        counter[c] -= 1

    print(f"Case #{i}: {sum(abs(counter[key]) for key in counter)}")
