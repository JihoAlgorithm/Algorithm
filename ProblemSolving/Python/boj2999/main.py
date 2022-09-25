import io
import os


def solution(message):
    l = len(message)
    for r in range(10, 0, -1):
        c = l // r
        if c >= r and r * c == l:
            cols = [message[i : i + r] for i in range(0, l, r)]
            return "".join(["".join(row) for row in zip(*cols)])
    raise Exception("INVALID INPUT")


print(
    solution(io.BytesIO(os.read(0, os.fstat(0).st_size)).readline().rstrip().decode())
)
