def dial(c):
    if c > "V":
        return 9, ord(c) - ord("V")
    if c > "S":
        return 8, ord(c) - ord("S")
    if c > "O":
        return 7, ord(c) - ord("O")

    t = (ord(c) - 65) // 3
    return 2 + t, ord(c) - (t * 3 + 64)


def press(prev, curr):
    pn, pi = dial(prev)
    cn, ci = dial(curr)
    return p * ci + (w if pn == cn and curr != " " else 0)


p, w = map(int, input().split())
message = input()
shifted = " " + message

print(sum(press(p, c) for p, c in zip(shifted, message)))
