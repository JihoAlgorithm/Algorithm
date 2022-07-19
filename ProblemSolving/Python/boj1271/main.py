import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

n, m = map(int, read().decode().split())

print(n // m)
print(n % m)
