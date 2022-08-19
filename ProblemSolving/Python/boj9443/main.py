arrange = [False] * 27

for _ in range(int(input())):
    arrange[ord(input()[0]) - 65] = True

for i, c in enumerate(arrange):
    if not c:
        print(i)
        break
