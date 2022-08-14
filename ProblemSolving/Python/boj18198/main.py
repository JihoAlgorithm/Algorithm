log = input()
table = {"A": 0, "B": 0}

for player, point in zip(log[::2], log[1::2]):
    table[player] += int(point)

print([*"AB"][table["A"] < table["B"]])
