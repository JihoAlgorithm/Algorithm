for _ in range(int(input())):
    target = input()
    keys = " " + input()
    res = ""
    for c in target:
        res += keys[ord(c) & 31]
    print(res)
