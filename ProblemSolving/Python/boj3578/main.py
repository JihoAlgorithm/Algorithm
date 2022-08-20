h = int(input())

if h == 0:
    print(1)
elif h == 1:
    print(0)
elif h & 1:
    print("4" + "8" * (h >> 1))
else:
    print("8" * (h >> 1))
