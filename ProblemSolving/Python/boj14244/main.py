import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

n, m = map(int, read().decode().split())

node = 1
leaf = 0

answer = []

while leaf < m:
    answer.append(f"0 {node}")
    node += 1
    leaf += 1

while node < n:
    answer.append(f"{node - 1} {node}")
    node += 1

print("\n".join(answer))
