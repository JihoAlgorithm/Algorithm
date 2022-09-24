import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
mapper = "  d b    i     oqp    vwx  "

while 1:
    word = input().rstrip()
    if word == b"#":
        break

    mirror = "".join(map(lambda c: mapper[c & 31], reversed(word)))
    print("INVALID" if " " in mirror else mirror)
