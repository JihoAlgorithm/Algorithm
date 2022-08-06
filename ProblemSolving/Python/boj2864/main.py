import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

A, B = read().decode().split()


def generate_min_max_numbers(number_string):
    minN, maxN = 0, 0
    for c in number_string:
        n = ord(c) & 15
        if 5 <= n <= 6:
            minN = (minN << 3) + (minN << 1) + 5
            maxN = (maxN << 3) + (maxN << 1) + 6
        else:
            minN = (minN << 3) + (minN << 1) + n
            maxN = (maxN << 3) + (maxN << 1) + n
    return minN, maxN


minA, maxA = generate_min_max_numbers(A)
minB, maxB = generate_min_max_numbers(B)

print(minA + minB, maxA + maxB)
