import io
import os
from collections import Counter

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

n = int(input().decode())
a = [*map(int, input().decode().split())]


def agg(iter):
    return Counter(iter)


def max_frequency(iter):
    return agg(iter).most_common(1)[0]


def parse(mod: int):
    freq = max_frequency(agg(map(lambda x: x % mod, a)))
    return {"m": mod, "k": freq[0], "f": freq[1]}


def is_half(d):
    global n
    x = n + 1 if n & 1 else n
    return d["f"] >= (x >> 1)


ans = [*filter(is_half, map(parse, range(2, max(a))))][0]
print(ans["m"], ans["k"])
