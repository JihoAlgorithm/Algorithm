A, B = input().split()
b_sum = sum(map(int, [b for b in B]))
prefix = 0

for a in A:
    prefix += int(a) * b_sum

print(prefix)
