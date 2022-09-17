LOVE = ["LO", "LV", "LE", "OV", "OE", "VE"]


def reduce(f, iter):
    r = iter[0]
    del iter[0]
    for data in iter:
        r = f(r, data)
    return r


yd_name = input()
names = [input() for _ in range(int(input()))]

yd_counts = [sum(yd_name.count(k) for k in c) for c in LOVE]
total_counts = [
    [sum(name.count(k) for k in c) + yd_counts[i] for i, c in enumerate(LOVE)]
    for name in names
]
ratios = [reduce(lambda a, b: a * b, count) % 100 for count in total_counts]

print(
    min(filter(lambda x: x[0] == max(ratios), zip(ratios, names)), key=lambda x: x[1])[
        1
    ]
)
