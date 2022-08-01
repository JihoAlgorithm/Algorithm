import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

N = int(read().decode())
stores = [*map(int, read().decode().split())]

last_milk = 0

for store in stores:
    if last_milk % 3 == store:
        last_milk += 1

print(last_milk)
