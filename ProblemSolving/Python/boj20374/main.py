import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

e = 0

while True:
    s = input()
    if not s:
        break
    a, b = map(int, s.decode().split("."))
    e += a * 100 + b

print("%.2f" % (e / 100))
