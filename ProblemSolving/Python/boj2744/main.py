def swap(c):
    n = ord(c)
    return chr(n - 32) if n >= 97 else chr(n + 32)


print("".join(map(swap, input())))
