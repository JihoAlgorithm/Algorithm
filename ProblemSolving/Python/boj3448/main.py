import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

for _ in range(int(input())):
    paragraph = []

    while 1:
        line = input().rstrip()
        if line == b"":
            break
        paragraph.append(line)

    error = sum(map(lambda l: l.count(b"#"), paragraph))
    length = sum(map(len, paragraph))
    raw_ratio = round(100 - error / length * 100, 1)
    ratio = raw_ratio if raw_ratio * 10 % 10 else int(raw_ratio)

    print(f"Efficiency ratio is {ratio}%.")
