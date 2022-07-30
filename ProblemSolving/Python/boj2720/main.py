import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline
T = map(int, [read().decode() for _ in range(int(read().decode()))])

quarter = lambda x: x // 25
dime = lambda x: x % 25 // 10
nickel = lambda x: x % 25 % 10 // 5
penny = lambda x: x % 5

print("\n".join([f"{quarter(C)} {dime(C)} {nickel(C)} {penny(C)}" for C in T]))
