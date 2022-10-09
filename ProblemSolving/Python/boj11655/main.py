import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
S = input().rstrip()


def ROT13(c):
    if 96 < c < 123:
        res = c + 13
        return chr(res if res < 123 else res - 26)
    if 64 < c < 91:
        res = c + 13
        return chr(res if res < 91 else res - 26)
    return chr(c)


print(*map(ROT13, S), sep="")
