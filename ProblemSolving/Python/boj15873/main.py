i = input()
l = len(i)
r = 0

if l < 3:
    r = sum(map(int, i))
elif l == 3:
    r = 10 + max(int(i[0]), int(i[2]))
else:
    r = 20

print(r)
