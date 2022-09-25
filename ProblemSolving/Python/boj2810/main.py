import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N = int(input())
seats = input().rstrip()
holders = seats.replace(b"S", b"*").replace(b"LL", b"*")

print(min(len(seats), len(holders) + 1))
