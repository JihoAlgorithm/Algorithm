count = 0
indicator = 0

for _ in range(8):
    for i, c in enumerate(input()):
        if i & 1 == indicator:
            count += c == "F"
    indicator ^= 1

print(count)
