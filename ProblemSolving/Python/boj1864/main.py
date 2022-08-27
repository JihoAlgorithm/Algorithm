mapper = {
    "-": 0,
    "\\": 1,
    "(": 2,
    "@": 3,
    "?": 4,
    ">": 5,
    "&": 6,
    "%": 7,
    "/": -1,
}

while True:
    octo = input()
    if octo == "#":
        break

    prefix = 0
    length = len(octo) - 1
    for c in octo:
        prefix += mapper[c] * (8**length)
        length -= 1

    print(prefix)
