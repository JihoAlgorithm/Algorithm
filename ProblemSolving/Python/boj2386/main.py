while True:
    k = input()
    if k == "#":
        break

    c, s = k.split(" ", 1)
    print(c, s.lower().count(c))
