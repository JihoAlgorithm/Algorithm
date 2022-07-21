import io
import os

n = (int(io.BytesIO(os.read(0, os.fstat(0).st_size)).readline()) // 3) - 1
print((n**2 - n) // 2)
