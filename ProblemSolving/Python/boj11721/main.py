s = input()
chunks, size = len(s), 10
for i in range(0, chunks, size):
    print(s[i : i + size])
