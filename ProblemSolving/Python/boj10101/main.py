import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

a = int(input().decode())
b = int(input().decode())
c = int(input().decode())
s = a + b + c

if s != 180:
    print("Error")
else:
    if a == b == c:
        print("Equilateral")
    elif a == b or b == c or c == a:
        print("Isosceles")
    else:
        print("Scalene")
