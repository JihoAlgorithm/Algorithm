import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

while 1:
    s = input().rstrip()
    if s == b"#":
        break

    target, guess = s.split()
    black, grey, white = [0, 0, 0]

    remains = [0] * 27
    visited = [False] * len(target)

    for i, z in enumerate(zip(target, guess)):
        t, g = z

        if t == g:
            black += 1
            visited[i] = True

    for i, z in enumerate(zip(target, guess)):
        t, g = z

        if t != g:
            if i > 0 and t == guess[i - 1] and not visited[i - 1]:
                grey += 1
                visited[i - 1] = True
            elif i + 1 < len(target) and t == guess[i + 1] and not visited[i + 1]:
                grey += 1
                visited[i + 1] = True
            else:
                remains[t & 31] += 1

    for v, g in zip(visited, guess):
        if not v and remains[g & 31]:
            remains[g & 31] -= 1
            white += 1

    print(f"{guess.decode()}: {black} black, {grey} grey, {white} white")
