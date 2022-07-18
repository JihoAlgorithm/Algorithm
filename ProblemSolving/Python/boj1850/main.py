import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

A, B = map(int, input().decode().split())


def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)


print("1" * gcd(A, B))
