import io
import os

print(chr(io.BytesIO(os.read(0, os.fstat(0).st_size)).readline()[-2]))
