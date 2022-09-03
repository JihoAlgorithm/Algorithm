def reduce(f, it, init):
    v = init
    for e in it:
        v = f(v, e)
    for i in range(3):
        if v & (1 << i):
            return i + 1
    return -1


def swap(state, command):
    r = state
    a = (2 + (ord(command) & 31)) % 3
    b = (a + 1) % 3
    r ^= 1 << a
    r ^= 1 << b
    return r if r < 5 else state


print(reduce(swap, input(), 1))
