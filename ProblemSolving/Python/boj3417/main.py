import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
mapper = [[chr((i + j + 1) % 26 + 65) for j in range(26)] for i in range(26)]

while 1:
    key = input()
    if key == b"0\n":
        break
    plain = input()[:-1]
    length = len(key) - 1

    res = [
        mapper[(key[i % length] & 31) - 1][(b & 31) - 1] for i, b in enumerate(plain)
    ]
    print(*res, sep="")
