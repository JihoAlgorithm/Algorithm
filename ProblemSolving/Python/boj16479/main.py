K = int(input())
D1, D2 = map(int, input().split())

if D1 == D2:
    print(K**2)
else:
    s = (D1 - D2) / 2
    print(K**2 - s**2)
