import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
mapper = [[chr((i + j - 1) % 26 + 65) for j in range(27)] for i in range(27)]

while 1:
    key = input().rstrip()
    if key == b"0":
        break
    plain = input().rstrip()
    length = len(key)

    res = [mapper[key[i % length] & 31][b & 31] for i, b in enumerate(plain)]
    print(*res, sep="")
