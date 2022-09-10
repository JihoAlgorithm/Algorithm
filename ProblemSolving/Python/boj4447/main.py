import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

for _ in range(int(input())):
    name = input().rstrip()
    g_count = name.lower().count(b"g")
    b_count = name.lower().count(b"b")
    result = "is GOOD"

    if g_count == b_count:
        result = "is NEUTRAL"
    if g_count < b_count:
        result = "is A BADDY"

    print(name.decode(), result)
