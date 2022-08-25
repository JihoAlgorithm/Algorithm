N = int(input())
s = "".join(map(str, range(1, N + 1)))

print(s.find(str(N)) + 1)
