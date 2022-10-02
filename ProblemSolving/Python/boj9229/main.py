import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

while 1:
    prev = input().rstrip()
    if prev == b"#":
        break

    answer = "Correct"

    while 1:
        curr = input().rstrip()
        if curr == b"#":
            break

        if len(prev) != len(curr) or sum(a != b for a, b in zip(prev, curr)) != 1:
            answer = "Incorrect"

        prev = curr

    print(answer)
