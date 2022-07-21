import io
import os

read = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

tc = 0
answer = []


while True:
    a, b, c = map(int, read().decode().split())
    if sum([a, b, c]) == 0:
        break

    tc += 1
    answer.append(f"Triangle #{tc}")

    if c < 0:
        answer.append("c = %.3f" % (a**2 + b**2) ** 0.5)
    elif max(a, b) >= c:
        answer.append("Impossible.")
    elif a < 0:
        answer.append("a = %.3f" % (c**2 - b**2) ** 0.5)
    elif b < 0:
        answer.append("b = %.3f" % (c**2 - a**2) ** 0.5)

    answer.append("")


print("\n".join(answer))
