import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

changes = 1000 - int(read().decode())
count = 0

count += changes // 500
count += changes % 500 // 100
count += changes % 100 // 50
count += changes % 50 // 10
count += changes % 10 // 5
count += changes % 5

print(count)
